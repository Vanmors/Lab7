package com.company;

import com.company.Database.CollectionDB;
import com.company.Database.ParseDB;
import com.company.Database.ServerDB;
import com.company.ServerConnection.ServerAccepter;
import com.company.data.Flat;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Main class
 * <img src="doc-files/ITMO_VT.jpg" alt="bla"/>
 */
public class Main {

    /**
     * метод, создающий экземпляр класса CommandChecker и вызывающий метод ServerConnect, запускающий работу программы
     * @param args аргумент командной строки
     * @throws IOException исключение
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, NoSuchAlgorithmException {
        Map<String, String> passwordMap = new HashMap<>();
        ServerDB serverDB = new ServerDB();
        Stack<Flat> st = new Stack<>();
        serverDB.createTableServer();
        ParseDB parseDB = new ParseDB();
        parseDB.parse(st);

        //serverDB.insertIntoTableServer();
        //parseDB.parse();

        while(true) {
            //args[0] = "asdfghjkl";
                ServerAccepter.ServerConnect(st, passwordMap);
                break;
            }
        }
    }
