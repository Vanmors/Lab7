package com.company.Threads;

import com.company.data.Flat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//public class FThread implements Runnable{
//    private SelectionKey selKey;
//    private ServerSocketChannel ssChannel1;
//    public Stack<Flat> st;
//    public FThread(SelectionKey selKey, ServerSocketChannel ssChannel1, Stack<Flat> st){
//        this.selKey = selKey;
//        this.ssChannel1 = ssChannel1;
//        this.st = st;
//    }
//    @Override
//    public void run() {
//        ServerSocketChannel ssChannel = (ServerSocketChannel) selKey.channel();
//        SocketChannel sChannel = null;
//        try {
//            sChannel = ssChannel1.accept();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        ByteBuffer bufferRaed = ByteBuffer.allocate(30000);
//        try {
//            //assert sChannel != null;
////            assert sChannel != null;
//            sChannel.read(bufferRaed);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(new CachedThreadPoll(bufferRaed, sChannel, st));
//
//        System.out.println(bufferRaed);
//        bufferRaed.flip();
//
//
//    }
//}
