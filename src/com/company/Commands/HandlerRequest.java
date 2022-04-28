package com.company.Commands;

import com.company.data.Flat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class HandlerRequest {
    static public ByteBuffer handelr(Stack<Flat> st, ByteBuffer bufferRead) throws IOException, ClassNotFoundException {
        try {
            ICommand reques = (ICommand) new ObjectInputStream(new ByteArrayInputStream(bufferRead.array())).readObject();
            System.out.println(reques);

            String help = reques.execute(st);
            byte[] bs = help.getBytes(StandardCharsets.UTF_8);
            ByteBuffer bufferWriter = ByteBuffer.wrap(bs);
            return bufferWriter;
        } catch (StreamCorruptedException e) {
            return bufferRead;
        }
    }
}
