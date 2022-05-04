package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShowCommand implements Serializable, ICommand {
    /**
     * выводит в стандартный поток вывода все элементы коллекции в строковом представлении
     * @param st объект коллекции Stack
     */
    private static final long serialVersionUID = 1L;
    @Override
    public String execute(Stack<Flat> st) {
        if (!st.empty()){
            ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
            String collectionShow = copyOfCollection
                    .stream()
                    .map(flat -> flat.toString() + "\n============\n")
                    .collect(Collectors.joining());
            return collectionShow;
        }
        else{
            return "collection is empty";
        }
    }

}

