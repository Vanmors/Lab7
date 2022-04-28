package com.company.Commands;

import com.company.data.Flat;
import com.company.data.House;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class RemoveAllByHouseCommand {
    /**
     * удаляет из коллекции все элементы, значение поля house которого эквивалентно заданному
     * @param st объект коллекции Stack
     */
    static public void removeAllByHouse(Stack<Flat> st) {
        if (!st.empty()) {
            while(true) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Введите name");
                    String name = sc.nextLine();
                    System.out.println("Введите year");
                    int year = sc.nextInt();
                    System.out.println("Введите numberOfFlatsOnFloor");
                    int numberOfFlatsOnFloor = sc.nextInt();
                    House house = new House(name, year, numberOfFlatsOnFloor);
                    ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
                    for (Flat flat : copyOfCollection) {
                        if (flat.getHouse().getName().equals(name)
                                && flat.getHouse().getYear().equals(year)
                                && flat.getHouse().getNumberOfFlatsOnFloor().equals(numberOfFlatsOnFloor)) {
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
    }
}
