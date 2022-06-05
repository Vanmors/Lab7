package com.company.Stack;

import com.company.data.Flat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Stack;

public interface Parsiable {
    public void parse (Stack<Flat> stack) throws IOException;
}
