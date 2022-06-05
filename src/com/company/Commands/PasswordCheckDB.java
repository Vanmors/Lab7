package com.company.Commands;

import com.company.Database.PasswordDB;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.Map;

public class PasswordCheckDB {
    private ByteBuffer buffer;
    private Map<String, String> passwordMap;

    public PasswordCheckDB(ByteBuffer buffer, Map<String, String> passwordMap){
        this.buffer = buffer;
        this.passwordMap = passwordMap;
    }

    public String passwordCheck() {
        String result = "notEntered";
        String s = "";
        try {
            while (true) {
                s = s + (char) buffer.get();
            }
        } catch (BufferUnderflowException e) {

        }
        String[] n = s.split(" ");
        if (n[0].equals("password")){
            PasswordDB passwordDB = new PasswordDB(n[1], n[2]);
            passwordDB.createPasswordTable();
            passwordDB.insertIntoTable();
            result = "Entered";
        }
        return result;
    }

}
