package com.company.Commands;

import com.company.data.Coordinates;
import com.company.data.Flat;
import com.company.data.House;
import com.company.data.View;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class AddCommand implements Serializable, ICommand {
    private static final long serialVersionUID = 1L;
    /**
     * добавляет элемент в коллекцию
     * @param st объект коллекции Stack
     */
    public String execute(Stack<Flat> st, Flat f){
        st.push(f);
        return "Объект добавлен в коллекцию";
    }

    @Override
    public String execute(Stack<Flat> st) {
        return "true";
    }
}
