package com.company.Commands;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Map;

public class PasswordCheck {
    private ByteBuffer buffer;
    private Map<String, String> passwordMap;

    public PasswordCheck(ByteBuffer buffer, Map<String, String> passwordMap){
        this.buffer = buffer;
        this.passwordMap = passwordMap;
    }

    public boolean passwordCheck() {
        String s = "";
        try {
            while (true) {
                s = s + (char) buffer.get();
            }
        } catch (BufferUnderflowException e) {

        }
        String[] n = s.split(" ");
        if (n[0].equals("password")){
            passwordMap.put(n[1], n[2]);
            System.out.println(passwordMap);
            return true;
        }
        return false;
    }

}
