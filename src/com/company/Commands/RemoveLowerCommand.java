package com.company.Commands;

import com.company.data.Flat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class RemoveLowerCommand {
    /**
     * удаляет из коллекции все элементы, меньшие, чем заданный
     * @param st объект коллекции Stack
     * @param n передаёт массив из названия команды и заданного числа
     */
    static public void removeLower(Stack<Flat> st, String[] n) {
        if (!st.empty()) {
            while (true) {
                try {
                    int maxNumberOfRooms = Integer.parseInt(n[1]);
                    ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
                    for (Flat flat : copyOfCollection) {
                        if (flat.getNumberOfRooms() < maxNumberOfRooms) {
                            st.remove(st.get(flat.getId() - 1));
                        }
                    }
                    if (maxNumberOfRooms>=0) {
                        break;
                    }
                    else{
                        System.out.println("Некорректно введённые данные");
                    }
                }
                catch (InputMismatchException e){
                    System.out.println("Некорректно введены данные");
                }
            }
        }
    }
}
