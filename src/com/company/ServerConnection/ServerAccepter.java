package com.company.ServerConnection;

import com.company.Commands.HandlerRequest;
import com.company.data.Flat;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Stack;

public class ServerAccepter {
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static SocketChannel sockch;
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет
    public static void ServerConnect(String f, Stack<Flat> st) throws IOException, ClassNotFoundException {
        String s = "";
        Selector selector = Selector.open();
        ServerSocketChannel ssChannel1 = ServerSocketChannel.open();
        ssChannel1.configureBlocking(false);
        ssChannel1.socket().bind(new InetSocketAddress(4009));
        HandlerRequest handlerRequest = new HandlerRequest();
        // Register both channels with selector
        ssChannel1.register(selector, SelectionKey.OP_ACCEPT);

        // Wait for an event
        while (true){
        selector.select();

        // Get list of selection keys with pending events
        Iterator it = selector.selectedKeys().iterator();

        // Process each key
        while (it.hasNext()) {
            // Get the selection key
            SelectionKey selKey = (SelectionKey) it.next();

            // Remove it from the list to indicate that it is being processed
            it.remove();

            // Check if it's a connection request
            if (selKey.isAcceptable()) {
                // Get channel with connection request
                ServerSocketChannel ssChannel = (ServerSocketChannel) selKey.channel();
                // Accepting a Connection on a ServerSocketChannel
                SocketChannel sChannel = ssChannel.accept();

                // If serverSocketChannel is non-blocking, sChannel may be null

                    ByteBuffer bufferRaed = ByteBuffer.allocate(30000);
                    sChannel.read(bufferRaed);
                    System.out.println(bufferRaed);
                    bufferRaed.flip();

                    ByteBuffer bufferWrite = ByteBuffer.allocate(300000);
                    bufferWrite = handlerRequest.handelr(st, bufferRaed, f);
                    sChannel.write(bufferWrite);

//                    sChannel.close();
                }



                // Use the socket channel to communicate with the client
//                    ByteBuffer buffer = ByteBuffer.allocate(1024);
//                    sChannel.read(buffer);
//                    buffer.flip();
//                    try {
//                        while (true) {
//                            s = s + (char) buffer.get();
//                        }
//                    } catch (BufferUnderflowException e) {
//                        System.out.print("");
//                    }
//                    CommandChecker com = new CommandChecker();
//                    ByteArrayOutputStream byteArrayOutputStream = com.exit(f,s);
//                    byte[] bytes = byteArrayOutputStream.toByteArray();
//                    byteArrayOutputStream.flush();
////                    int length = byteArrayOutputStream.size();
//                    ByteBuffer bufferWrite = ByteBuffer.allocate(1024);
//                    bufferWrite.put(bytes);
//                    System.out.println(bytes);
//                    System.out.println(bufferWrite);
//                    bufferWrite.flip();
//                    sChannel.write(bufferWrite);
//                    sChannel.close();
//                }

                }
            }
    }
}
