package com.company.Commands;

import com.company.data.Flat;
import com.company.data.House;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class RemoveAllByHouseCommand implements ICommand, Serializable {
    private static final long serialVersionUID = 2L;
    House h;
    int id;
    /**
     * удаляет из коллекции все элементы, значение поля house которого эквивалентно заданному
     * @param st объект коллекции Stack
     */
    public RemoveAllByHouseCommand(House h,int id){
        this.h = h;
        this.id = id;
    }

    @Override
    public String execute(Stack<Flat> st) {
        if (!st.empty()) {
            while(true) {
                try {
                    ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
                    for (Flat flat : copyOfCollection) {
                        if (flat.getHouse().getName().equals(h.getName())
                                && flat.getHouse().getYear().equals(h.getYear())
                                && flat.getHouse().getNumberOfFlatsOnFloor().equals(h.getNumberOfFlatsOnFloor())) {
                            st.remove(st.get(flat.getId()-1));
                            System.out.println("Элемент удалён");
                        }
                    }
                    break;
                }
                catch (InputMismatchException e){
                    System.out.println("Некорректно введены данные");
                }
            }
        }
        return "Complete";
    }
}
