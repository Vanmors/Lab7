package com.company.Commands;

import com.company.data.Flat;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class RemoveByIdCommand {
    /**
     * удаляет элемент из коллекции по его id
     * @param st объект коллекции Stack
     * @throws ArrayIndexOutOfBoundsException
     */
    static public void removeById(Stack<Flat> st) throws ArrayIndexOutOfBoundsException {
        ArrayList<Flat> list = new ArrayList(st);
        long count = 0;
        for (Flat flat : list) {
            count += 1;
        }
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Введите id элемента, который хотите удалить");
                int k = sc.nextInt();
                if (k > 0 || k < count ) {
                    st.remove(st.get(k - 1));
                    System.out.println("Элемент удалён");
                    break;
                } else {
                    System.out.println("Некорректно введены данные");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введены данные");
            }
        }
    }
}
