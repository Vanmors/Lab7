package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.Stack;

public class AddCommand implements Serializable, ICommand {
    private static final long serialVersionUID = 1L;
    private Flat f;

    /**
     * добавляет элемент в коллекцию
     *
     * @param st объект коллекции Stack
     */

    public AddCommand(Flat f) {
        this.f = f;
    }

    public String execute(Stack<Flat> st)
    {   f.setID(st.peek().getId()+1);
        st.push(f);
        return "Object insert in collection";
    }

}
