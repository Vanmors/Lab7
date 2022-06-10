package com.company.Threads;

import com.company.Commands.HandlerRequest;
import com.company.Commands.PasswordCheckDB;
import com.company.data.Flat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Stack;

public class CachedThreadPoll implements Runnable {
    public ByteBuffer bufferRaed;
    public SocketChannel sChannel;
    public Stack<Flat> st;

    public CachedThreadPoll(ByteBuffer bufferRaed, SocketChannel sChannel, Stack<Flat> st) {
        this.bufferRaed = bufferRaed;
        this.sChannel = sChannel;
        this.st = st;
    }

    @Override
    public void run() {
        HandlerRequest handlerRequest = new HandlerRequest();
        String result = null;
        PasswordCheckDB passwordCheck = new PasswordCheckDB(bufferRaed);
        try {
            result = passwordCheck.passwordCheck();
            if (result.equals("Entered") || result.equals("Incorrect password")) {
                ByteBuffer bufferWrite;
                //String OK = "Entered";
                byte[] bs = result.getBytes(StandardCharsets.UTF_8);
                bufferWrite = ByteBuffer.wrap(bs);
                sChannel.write(bufferWrite);
                new Thread(new LThread(bufferWrite, sChannel)).start();
            } else if (result.equals("wasEntered")) {
                ByteBuffer bufferWrite;
                bufferWrite = handlerRequest.handelr(st, bufferRaed);
                new Thread(new LThread(bufferWrite, sChannel)).start();
            }
        } catch (SQLException | NoSuchAlgorithmException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
