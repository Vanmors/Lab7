package com.company;

import com.company.Commands.CommandChecker;
import com.company.ServerConnection.ServerAccepter;
import com.company.Stack.Parse;
import com.company.data.Flat;

import java.io.*;
import java.util.Stack;

/**
 * Main class
 * <img src="doc-files/ITMO_VT.jpg" alt="bla"/>
 */
public class Main {
    /**
     * метод, создающий экземпляр класса CommandChecker и вызывающий метод exit, запускающий работу программы
     * @param args аргумент командной строки
     * @throws IOException исключение
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * создание экземпляр класса CommandChecker
         */
        CommandChecker com = new CommandChecker();
        ByteArrayOutputStream byteArrayOutputStream;

        while(true) {
            if (args.length == 1 &&
                    !args[0].equals("/dev/null") &&
                    !args[0].equals("/dev/random") &&
                    !args[0].equals("/dev/zero")) {

//                Parse p = new Parse();
                Stack<Flat> st = new Stack<>();
//                p.parse(args[0], st);
                ServerAccepter.ServerConnect(args[0], st);
                break;
            } else {
                System.out.println("Введено больше одного файла или не введено вообще");
                break;
            }
        }
    }
}
