package com.company.Commands;

import com.company.data.Flat;
import com.company.excepption.UnknownCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class ExecuteScriptCommand implements ICommand, Serializable {
    private static final long serialVersionUID = 3L;
    private String scriptFile;
    private ArrayList<String> list;

    public ExecuteScriptCommand(String scriptFile) {
        this.scriptFile = scriptFile;
    }

    /**
     * проверяет команды в скрипте и выполняет их
     *
     * @param f   имя скрипта
     * @param scr передаёт массив из названия команды и заданного числа
     * @param st  объект коллекции Stack
     * @throws IOException
     */
    @Override
    public String execute(Stack<Flat> st) {
        String result = null;
        int id = 0;
        try {
            File file = new File(scriptFile);
            Scanner sc = new Scanner(file);
            while (true) {
                if (sc.hasNextLine()) {
                    String command = sc.nextLine();
                    String[] n = command.split(" ");
                    try {
                        id = Integer.parseInt(n[1]);
                    }
                    catch (ArrayIndexOutOfBoundsException e){

                    }
                    if ((command.equals("exit"))) {
                        System.exit(0);
                    } else if (command.equals("help")) {
                        result = result + "\n" + new HelpCommand().execute(st);
                    } else if (command.equals("show")) {
                        result = result + "\n" + new ShowCommand().execute(st);
                    } else if (command.equals("add")) {
                        AddScriptCommand.add(st, sc);
                        String delete = sc.nextLine();
                    } else if (command.equals("remove_by_id")) {
                        result = result + "\n" + new RemoveByIdCommand(id).execute(st);
                    } else if (command.equals("clear")) {
                        result = result + "\n" + new ClearCommand().execute(st);
                    } else if (command.equals("average_of_number_of_rooms")) {
                        result = result + "\n" + new AverageOfNumberOfRooms().execute(st);
                    } else if (command.equals("reorder")) {
                        result = result + "\n" + new ReorderCommand().execute(st);
                    } else if (command.equals("max_by_furniture")) {
                        result = result + "\n" + new MaxByFurnitureCommand().execute(st);
                    } else if (command.equals("info")) {
                        result = result + "\n" + new InfoCommand().execute(st);
                    } else if (command.equals("execute_script " + n[1])) {
                        list.add(n[1]);
                        int count = list.size() - 1;
                        int i = 0;
                        for (String ff : list) {
                            if (n[1].equals(ff)) {
                                i++;
                            }
                        }
                        if (i == 2) {
                            System.out.println("Вызывает рекурсию");
                            break;
                        } else {
                            new ExecuteScriptCommand(n[1]).execute(st);
                        }
                    } else if (n[0].equals("update_id")) {
                        try {
                            UpdateIdScriptCommand.updateIdScriptCommand(st, sc, n);
                            String delete = sc.nextLine();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Команда введена неверно");
                        }
                    } else if (n[0].equals("remove_lower")) {
                        try {
                            new RemoveLowerCommand(id).execute(st);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Команда введена неверно");
                        }
                    } else if (command.equals("add_if_min")) {
                        AddIfMinScriptCommand.addIfMinScriptCommand(st, sc);
                        String delete = sc.nextLine();
                    } else {
                        throw new UnknownCommandException(command);
                    }
                    if (sc.hasNextLine()) {
                        //command = sc.nextLine();
                    } else {
                        return result;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnknownCommandException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}