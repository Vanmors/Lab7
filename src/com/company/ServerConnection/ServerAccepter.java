package com.company.ServerConnection;

import com.company.Commands.HandlerRequest;
import com.company.Commands.PasswordCheckDB;
import com.company.data.Flat;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class ServerAccepter {

    public static void ServerConnect(String f, Stack<Flat> st, Map<String, String> passwordMap) throws ClassNotFoundException, SQLException, IOException, NoSuchAlgorithmException {
        Selector selector = Selector.open();
        ServerSocketChannel ssChannel1 = ServerSocketChannel.open();
        ssChannel1.configureBlocking(false);
        ssChannel1.socket().bind(new InetSocketAddress(6123));
        HandlerRequest handlerRequest = new HandlerRequest();

        ssChannel1.register(selector, SelectionKey.OP_ACCEPT);


        while (true) {
            try {
                selector.select();

                Iterator it = selector.selectedKeys().iterator();

                while (it.hasNext()) {
                    SelectionKey selKey = (SelectionKey) it.next();

//            it.remove();
                    if (selKey.isAcceptable()) {
                        ServerSocketChannel ssChannel = (ServerSocketChannel) selKey.channel();
                        SocketChannel sChannel = ssChannel.accept();


                        ByteBuffer bufferRaed = ByteBuffer.allocate(30000);
                        sChannel.read(bufferRaed);
                        System.out.println(bufferRaed);
                        bufferRaed.flip();

                        PasswordCheckDB passwordCheck = new PasswordCheckDB(bufferRaed, passwordMap);
                        String result = passwordCheck.passwordCheck();
                        if (result.equals("Entered") || result.equals("Incorrect password")) {
                            ByteBuffer bufferWrite;
                            //String OK = "Entered";
                            byte[] bs = result.getBytes(StandardCharsets.UTF_8);
                            bufferWrite = ByteBuffer.wrap(bs);
                            sChannel.write(bufferWrite);
                        } else if (result.equals("wasEntered")) {
                            ByteBuffer bufferWrite;
                            bufferWrite = handlerRequest.handelr(st, bufferRaed, f);
                            sChannel.write(bufferWrite);
                        }
//                    sChannel.close();
                    }
                }
            } catch (IOException e) {

            }
        }
    }
}
