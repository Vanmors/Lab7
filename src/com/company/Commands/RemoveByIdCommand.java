package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class RemoveByIdCommand implements ICommand, Serializable {
    private static final long serialVersionUID = 1L;
    private String result;
    private int id;
    /**
     * удаляет элемент из коллекции по его id
     *
     * @param st объект коллекции Stack
     * @throws ArrayIndexOutOfBoundsException
     */
    public RemoveByIdCommand(int id){
        this.id = id;
    }

    @Override
    public String execute(Stack<Flat> st) throws ArrayIndexOutOfBoundsException {
        ArrayList<Flat> list = new ArrayList(st);
        long count = list.size();
            try {
                if (id > 0 || id < count) {
                    st.remove(st.get(id - 1));
                    result = "Item removed";
                } else {
                    result = "Data entered incorrectly";
                }
            } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
                result = "Data entered incorrectly";
            }
        return result;
    }
}
