

package com.company.Stack;

import com.company.data.Coordinates;
import com.company.data.Flat;
import com.company.data.House;
import com.company.data.View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Stack;
import java.time.ZonedDateTime;

public class Parse implements Parsiable {
    String FileName;

    /**
     *
     * @param FileName имя файла с коллекцией
     * @param st объект коллекции Stack
     * @throws IOException
     */
    public void parse(String FileName, Stack<Flat> st) throws IOException {
        this.FileName = FileName;
        FileInputStream f;
        while (true) {
            try {
                f = new FileInputStream(FileName);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден или у вас нет на него прав");
                System.exit(0);
            }
        }
        int c;
        while (f.available() != 0) {
            String word = "";
            while ((c = f.read()) != 10 && c != -1 &&  c != 13) {
                if (c != 34) {
                    word = word + (char) c;
                }

            }
            c = f.read();
            String[] words = word.split(",");
            while (true) {
                try {
                    try {
                        Coordinates inputCoordinate = new Coordinates(Integer.parseInt(words[2]), Long.parseLong(words[3]));
                        House house = new House(words[10], Integer.parseInt(words[11]), Integer.parseInt(words[12]));
                        Flat flat = new Flat(Integer.parseInt(words[0]), words[1], inputCoordinate, ZonedDateTime.now(),
                                Integer.parseInt(words[5]), Long.parseLong(words[6]), Boolean.valueOf(words[7]),
                                Long.parseLong(words[8]), View.valueOf(words[9]), house);
                        st.push(flat);
                        break;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Файл введён неверно");
                        System.exit(0);
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Файл введён неверно");
                    System.exit(0);
                }
            }
        }

    }
}

