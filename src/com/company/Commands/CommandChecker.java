package com.company.Commands;

import com.company.Stack.Parse;
import com.company.data.Flat;
import com.company.excepption.UnknownCommandException;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;


public class CommandChecker {
    /**
     * проверяет введёные пользователем данные и вызывает нужный метод
     * @param f имя файла с коллекцией
     * @throws IOException
     * @return
     */
    public ByteArrayOutputStream exit(String f, String s) throws IOException {
        Parse p = new Parse();
        Stack<Flat> st = new Stack<>();
        p.parse(f, st);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Scanner sc = new Scanner(System.in);
            try {
//                if (!s.hasNext()){
//                    System.exit(0);
//                }
                String command = s.trim();
//                System.out.println(command);
//                System.exit(0);
                ArrayList<String> list = new ArrayList<>();
                String[] n = command.split(" ");
                if ((command.equals("exit"))) {
                        System.exit(0);
                    } else if (command.equals("help")) {
                    HelpCommand helpCommand = new HelpCommand();

                    try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream))
                    {
                        objectOutputStream.writeObject(helpCommand);
                        objectOutputStream.flush();
                        System.out.println(byteArrayOutputStream);
//                        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
//                        String request = (String) new ObjectInputStream(new ByteArrayInputStream(buffer1.array())).readObject();
//                        System.out.println(request);
                    }
                    catch(Exception ex){

                        System.out.println(ex.getMessage());
                    }
                    //helpCommand.help();
//                } else if (command.equals("show")) {
//                        ShowCommand.execute(st);
//                    }
//                    else if (command.equals("add")) {
//                        AddCommand.add(st);
//                    }
//                    else if (command.equals("remove_by_id")) {
//                        RemoveByIdCommand.removeById(st);

//                    } else if (command.equals("average_of_number_of_rooms")) {
//                        AverageOfNumberOfRooms.average(st);
//                    } else if (command.equals("reorder")) {
//                        ReorderCommand.reorder(st);
//                    } else if (n[0].equals("execute_script")){
//                        ExecuteScriptCommand.executeScript(f, n,st, list);
//                    } else if(command.equals("max_by_furniture")){
//                        MaxByFurnitureCommand.maxFurniture(st);
//                    }
//                    else if(command.equals("info")){
//                        InfoCommand.info(st);
                    }
//                    else if(command.equals("save")){
//                        SaveCommand.save(f, st);
//                    }
//                    else if(command.equals("remove_all_by_house")){
//                        RemoveAllByHouseCommand.removeAllByHouse(st);
//                    }
//                    else if(n[0].equals("update_id")){
//                        try {
//                            UpdateIdCommand.updateID(st, n);
//                        }
//                        catch (ArrayIndexOutOfBoundsException e){
//                            System.out.println("Команда введена неверно");
//                        }
//                    }
//                    else if(n[0].equals("remove_lower")){
//                    try {
//                        com.company.Commands.RemoveLowerCommand.removeLower(st, n);
//                    }
//                    catch (ArrayIndexOutOfBoundsException e){
//                        System.out.println("Команда введена неверно");
//                    }
//                    }
//                    else if (command.equals("add_if_min")){
//                        AddIfMinCommand.addIfMin(st);
//                    }
                    else{
                        throw new UnknownCommandException(command);
                    }
                } catch (UnknownCommandException e) {
                    e.getMessage();
                }
            return byteArrayOutputStream;
            }
}

