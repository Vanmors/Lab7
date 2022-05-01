package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class UpdateIdCommand implements ICommand, Serializable {
    private static final long serialVersionUID = 2L;

    private Flat f;
    private int id;
    /**
     * обновляет значение элемента коллекции, id которого равен заданному
     * @param st объект коллекции Stack
     * @param n передаёт массив из названия команды и заданного числа
     */

    public UpdateIdCommand(Flat f, int id){
        this.f = f;
        this.id = id;
    }
    @Override
    public String execute(Stack<Flat> st) {
        String result = "Element changed";
        try {
            ArrayList<Flat> list = new ArrayList<>(st);
            list.set(id - 1, f);
            while (!st.empty()) {
                st.pop();
            }
            for (Flat flat : list) {
                st.push(flat);
            }
        }
        catch (IndexOutOfBoundsException e){
            result = "There is no element with this id";
        }
        return result;
    }
}
