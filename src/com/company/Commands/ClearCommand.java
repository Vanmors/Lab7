package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.Stack;

public class ClearCommand implements Serializable, ICommand{
    /**
     * очищает коллекцию
     * @param st объект коллекции Stack
     */
    private static final long serialVersionUID = 1L;
    @Override
    public String execute(Stack<Flat> st){
        while(!st.empty()){
            st.pop();
        }
        return "Complete";
    }

}
