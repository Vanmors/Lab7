package com.company.Commands;

import com.company.Stack.ProxyParse;
import com.company.data.Flat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class HandlerRequest {
    private int count = 0;
    public ByteBuffer handelr(Stack<Flat> st, ByteBuffer bufferRead, String f) throws IOException, ClassNotFoundException {
        try {
            ICommand reques = (ICommand) new ObjectInputStream(new ByteArrayInputStream(bufferRead.array())).readObject();
            System.out.println(reques);

            if (reques != null && count == 0) {
                ProxyParse pc = new ProxyParse(f, st, reques);
                pc.parse(f, st);
                count = 1;
            }

            String command = reques.execute(st);
            byte[] bs = command.getBytes(StandardCharsets.UTF_8);
            ByteBuffer bufferWriter = ByteBuffer.wrap(bs);
            return bufferWriter;
        } catch (StreamCorruptedException e) {
            return bufferRead;
        }
    }
}
