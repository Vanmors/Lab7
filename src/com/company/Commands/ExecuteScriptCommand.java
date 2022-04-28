//package com.company.Commands;
//
import com.company.data.Flat;
import com.company.excepption.UnknownCommandException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class ExecuteScriptCommand {
    /**
     * проверяет команды в скрипте и выполняет их
     * @param f имя скрипта
     * @param scr передаёт массив из названия команды и заданного числа
     * @param st объект коллекции Stack
     * @throws IOException
     */
    static public void executeScript(String f,String scr [],Stack<Flat> st, ArrayList<String> list) throws IOException {
//            try {
//                File file = new File(scr[1]);
//                Scanner sc = new Scanner(file);
//                HelpCommand helpCommand = new HelpCommand();
//                while (true) {
//                    try {
//                        String command = sc.nextLine();
//                        String[] n = command.split(" ");
//                        if ((command.equals("exit"))) {
//                            System.exit(0);
//                        } else if (command.equals("help")) {
//                            helpCommand.execute(st);
//                        } else if (command.equals("show")) {
//                            ShowCommand.showString(st);
//                        } else if (command.equals("add")) {
//                            AddScriptCommand.add(st, sc);
//                            String delete = sc.nextLine();
//                        } else if (command.equals("remove_by_id")) {
//                            RemoveByIdCommand.removeById(st);
//                        } else if (command.equals("clear")) {
//                            ClearCommand.execute(st);
//                        } else if (command.equals("average_of_number_of_rooms")) {
//                            AverageOfNumberOfRooms.average(st);
//                        } else if (command.equals("reorder")) {
//                            ReorderCommand.reorder(st);
//                        } else if (command.equals("max_by_furniture")) {
//                            MaxByFurnitureCommand.maxFurniture(st);
//                        } else if (command.equals("info")) {
//                            InfoCommand.info(st);
//                        } else if (command.equals("save")) {
//                            SaveCommand.save(f, st);
//                        } else if (command.equals("execute_script " + n[1])) {
//                            list.add(n[1]);
//                            int count = list.size()-1;
//                            int i = 0;
//                            for (String ff: list) {
//                                if (n[1].equals(ff)) {
//                                    i++;
//                                }
//                            }
//                            if (i == 2) {
//                                System.out.println("Вызывает рекурсию");
//                                break;
//                            }
//                            else{
//                                ExecuteScriptCommand.executeScript(list.get(count), n, st,list);
//                            }
//                        } else if (command.equals("remove_all_by_house")) {
//                            RemoveAllByHouseCommand.removeAllByHouse(st);
//                        } else if (n[0].equals("update_id")) {
//                            try {
//                                UpdateIdScriptCommand.updateIdScriptCommand(st, sc, n);
//                                String delete = sc.nextLine();
//                            } catch (ArrayIndexOutOfBoundsException e) {
//                                System.out.println("Команда введена неверно");
//                            }
//                        } else if (n[0].equals("remove_lower")) {
//                            try {
//                                RemoveLowerCommand.removeLower(st, n);
//                            } catch (ArrayIndexOutOfBoundsException e) {
//                                System.out.println("Команда введена неверно");
//                            }
//                        } else if (command.equals("add_if_min")) {
//                            AddIfMinScriptCommand.addIfMinScriptCommand(st, sc);
//                            String delete = sc.nextLine();
//                        } else {
//                            throw new UnknownCommandException(command);
//                        }
//                        if (sc.hasNextLine()) {
//                            //command = sc.nextLine();
//                        } else {
//                            break;
//                        }
//                    } catch (UnknownCommandException e) {
//                        e.getMessage();
//                        break;
////                        if (sc.hasNextLine()) {
////
////                        }
////                        else{
////                            break;
////                        }
//                    }
//                    catch (NoSuchElementException e){
//
//                    }
//                }
//            } catch (FileNotFoundException e) {
//                System.out.println("Такого файла не существует или на него нет прав");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
    }
}
