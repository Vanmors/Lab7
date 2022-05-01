package com.company.Stack;

import com.company.data.Flat;

import java.io.IOException;
import java.util.Stack;

public interface Parsiable {
    public void parse (String FileName, Stack<Flat> stack) throws IOException;
}
