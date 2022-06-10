package com.company.Threads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class LThread implements Runnable{
    public ByteBuffer bufferWrite;
    public SocketChannel sChannel;

    public LThread(ByteBuffer bufferWrite, SocketChannel sChannel){
        this.bufferWrite = bufferWrite;
        this.sChannel = sChannel;
    }

    @Override
    public void run() {
        try {
            sChannel.write(bufferWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
