package com.company.Commands;

import com.company.data.Flat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class AverageOfNumberOfRooms implements Serializable, ICommand{
    /**
     * выводит среднее значение поля numberOfRooms для всех элементов коллекции
     * @param st объект коллекции Stack
     */
    private static final long serialVersionUID = 1L;
    @Override
    public String execute(Stack<Flat> st) {
        double average = 0;
        int count = 1;
        if (!st.empty()) {
            count = 0;
            ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
            average = copyOfCollection.stream().mapToLong((flat) -> flat.getNumberOfRooms()).average().getAsDouble();
//            for (Flat flat : copyOfCollection) {
//                count += 1;
//                average += flat.getNumberOfRooms();
//            }

        }
        double result = average;
        return String.valueOf(result);
    }

}
