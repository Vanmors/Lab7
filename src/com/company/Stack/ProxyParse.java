package com.company.Stack;

import com.company.Commands.ICommand;
import com.company.data.Flat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Stack;

public class ProxyParse implements Parsiable{
    private String FileName;
    private Stack<Flat> stack;
    private ICommand iCommand;

    public ProxyParse(String FileName, Stack<Flat> stack, ICommand iCommand){
        this.FileName = FileName;
        this.stack = stack;
        this.iCommand = iCommand;

    }
    @Override
    public void parse(String FileName, Stack<Flat> stack) throws IOException {
        if(iCommand != null){
            Parse p = new Parse();
            p.parse(FileName, stack);
        }
    }
}
