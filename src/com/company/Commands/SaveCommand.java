package com.company.Commands;

import com.company.data.Flat;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SaveCommand {
    /**
     * сохранить коллекцию в файл
     * @param f файл в который сохраняется коллекция
     * @param st объект коллекции Stack
     * @throws IOException
     */
    static public void save(String f, Stack<Flat> st) throws IOException {
        try {
            List<String[]> list = creatCsvData(st);
            try (CSVWriter writer = new CSVWriter(new PrintWriter(f))) {
                writer.writeAll(list);
                System.out.println("Коллекция сохранена");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Нет прав на файл");
        }
    }

    /**
     * создаёт список данных из коллекции
     * @param st объект коллекции Stack
     * @return list
     */
    private static List<String[]> creatCsvData(Stack<Flat> st) {
        ArrayList<Flat> copyOfCollection = new ArrayList<>(st);
        List<String[]> list = new ArrayList<>();
        for (Flat flat: copyOfCollection) {
            list.add(flat.toStringForSave());
        }
        return list;
    }
}

