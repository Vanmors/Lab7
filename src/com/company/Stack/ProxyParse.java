package com.company.Stack;

import com.company.Commands.ICommand;
import com.company.Database.ParseDB;
import com.company.data.Flat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.SQLException;
import java.util.Stack;

public class ProxyParse implements Parsiable{
    private String FileName;
    private Stack<Flat> stack;
    private ICommand iCommand;

    public ProxyParse(Stack<Flat> stack, ICommand iCommand){
        this.stack = stack;
        this.iCommand = iCommand;

    }
    @Override
    public void parse(Stack<Flat> stack) throws IOException {
        if(iCommand != null){
            ParseDB p = new ParseDB();
            try {
                p.parse(stack);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
