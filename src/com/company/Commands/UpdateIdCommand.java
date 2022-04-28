package com.company.Commands;

import com.company.data.Coordinates;
import com.company.data.Flat;
import com.company.data.House;
import com.company.data.View;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class UpdateIdCommand {
    static Scanner sc = new Scanner(System.in);

    /**
     * обновляет значение элемента коллекции, id которого равен заданному
     * @param st объект коллекции Stack
     * @param n передаёт массив из названия команды и заданного числа
     */
    static public void updateID(Stack<Flat> st, String[] n) {
        try {
            int id = Integer.parseInt(n[1]);
            Flat f = new Flat(id, setName(), setCoordinates(), setCreationDate(),
                    setArea(), setNumberOfRooms(), setFurniture(), setTimeToMetroOnFoot(),
                    setView(), setHouse());
            ArrayList<Flat> list = new ArrayList<>(st);
            list.set(id - 1, f);
            while (!st.empty()) {
                st.pop();
            }
            for (Flat flat : list) {
                st.push(flat);
                System.out.println(flat);
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Элемента с таким id не существует");
        }
    }
    static public String setName(){
        Scanner nameSc = new Scanner(System.in);
        System.out.println("Введите Name");
        if (!nameSc.hasNextLine()){
            System.exit(0);
        }
        String Name = nameSc.nextLine();
        while ((Name.trim()).equals("")){
            System.out.println("Введите Name");
            if (!nameSc.hasNextLine()){
                System.exit(0);
            }
            Name = nameSc.nextLine();
        }
        return Name;
    }
    static public Coordinates setCoordinates() {
        while(true) {
            try {
                Scanner coordSc = new Scanner(System.in);
                System.out.println("Введите Coordinate X");
                if (!coordSc.hasNextLine()){
                    System.exit(0);
                }
                int x = coordSc.nextInt();
                System.out.println("Введите Coordinate Y");
                if (!coordSc.hasNextLine()){
                    System.exit(0);
                }
                long y = coordSc.nextLong();
                if (x>=0 && y>=0) {
                    return new Coordinates(x, y);
                }
                else{
                    System.out.println("Некорректно введённые данные");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введённые данные");
            }
        }
    }
    static public ZonedDateTime setCreationDate(){
        return ZonedDateTime.now();
    }
    static public int setArea(){
        while (true) {
            try {
                Scanner areaSc = new Scanner(System.in);
                System.out.println("Введите area");
                if (!areaSc.hasNextLine()){
                    System.exit(0);
                }
                int area = areaSc.nextInt();
                if (area>=0) {
                    return area;
                }
                else{
                    System.out.println("Некорректно введённые данные");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введённые данные");
            }
        }
    }
    static public Long setNumberOfRooms(){
        while(true) {
            try {
                Scanner NORsc = new Scanner(System.in);
                System.out.println("Введите number of rooms");
                if (!NORsc.hasNextLine()){
                    System.exit(0);
                }
                Long numberOfRooms = NORsc.nextLong();
                if (numberOfRooms>=0) {
                    return numberOfRooms;
                }
                else{
                    System.out.println("Некорректно введённые данные");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введённые данные");
            }
        }
    }
    static public Boolean setFurniture(){
        while(true) {
            try {
                Scanner furSc = new Scanner(System.in);
                System.out.println("Введите furniture");
                if (!furSc.hasNextLine()){
                    System.exit(0);
                }
                Boolean furniture = furSc.nextBoolean();
                return furniture;
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введённые данные");
            }
        }
    }
    static public Long setTimeToMetroOnFoot(){
        while(true) {
            try {
                Scanner metroSc = new Scanner(System.in);
                System.out.println("Введите time to metro on foot");
                if (!metroSc.hasNextLine()){
                    System.exit(0);
                }
                Long timeToMetroOnFoot = metroSc.nextLong();
                if (timeToMetroOnFoot>=0) {
                    return timeToMetroOnFoot;
                }
                else {
                    System.out.println("Некорректно введённые данные");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введённые данные");
            }
        }
    }
    static public View setView() {
        View v = null;
        while (true) {
            System.out.println("Введите view: TERRIBLE, STREET, BAD, PARK");
            Scanner viewSc = new Scanner(System.in);
            if (!viewSc.hasNextLine()){
                System.exit(0);
            }
            String view = viewSc.next();
            if (view.equals("TERRIBLE")) {
                v = View.TERRIBLE;
                break;
            } else if (view.equals("STREET")) {
                v = View.STREET;
                break;
            } else if (view.equals("BAD")) {
                v = View.BAD;
                break;
            } else if (view.equals("PARK")) {
                v = View.PARK;
                break;
            }
        }
        return v;
    }
    static public House setHouse(){
        while (true) {
            try {
                Scanner houseSc = new Scanner(System.in);
                System.out.println("Введите name of house");
                if (!houseSc.hasNextLine()){
                    System.exit(0);
                }
                String Name = houseSc.nextLine();
                System.out.println("Введите year of house");
                if (!houseSc.hasNextLine()){
                    System.exit(0);
                }
                Integer year = houseSc.nextInt();
                System.out.println("Введите number of flats on floor");
                if (!houseSc.hasNextLine()){
                    System.exit(0);
                }
                Integer numberOfFlatsOnFloor = houseSc.nextInt();
                if (year>=0 && numberOfFlatsOnFloor>=0) {
                    return new House(Name, year, numberOfFlatsOnFloor);
                }
                else{
                    System.out.println("Некорректно введённые данные");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Некорректно введённые данные");
            }
        }
    }
}
