package com.company.Commands;

import com.company.data.Coordinates;
import com.company.data.Flat;
import com.company.data.House;
import com.company.data.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

public class ReorderCommand implements Serializable, ICommand {
    /**
     * сортирует коллекцию в порядке, обратном нынешнему
     * @param st объект коллекции Stack
     */
    private static final long serialVersionUID = 1L;
    @Override
    public String execute(Stack<Flat> st) {
        ArrayList<Flat> list = new ArrayList<>(st);
        ClearCommand clear = new ClearCommand();
        clear.execute(st);
        int i;
        int id = 0;
        while(!list.isEmpty()){
            i = list.size()-1;
            id++;
            String name = list.get(i).getName();
            Coordinates coordinates = list.get(i).getCoordinates();
            java.time.ZonedDateTime creationDate = list.get(i).getCreationDate();
            int area = list.get(i).getArea();
            long numberOfRooms = list.get(i).getNumberOfRooms();
            Boolean furniture = list.get(i).getFurniture();
            long timeToMetro = list.get(i).getTimeToMetroOnFoot();
            View view = list.get(i).getView();
            House house = list.get(i).getHouse();
            Flat f = new Flat(id, name, coordinates, creationDate, area, numberOfRooms, furniture, timeToMetro, view, house);
            st.push(f);
            list.remove(i);
        }
        return "Complete";
    }

}
