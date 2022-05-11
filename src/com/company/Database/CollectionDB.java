package com.company.Database;

import com.company.data.Flat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CollectionDB {
    public void insertIntoTable(){
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = "INSERT INTO collection(Name, CoordinateX, CoordinateY, CreationTime, " +
                    "Area, NumberOfRooms, Furniture, " +
                    "TimeToMetroOnFoot, View, NameH, " +
                    "Year, NumberOfFlatsOnFloor) VALUES('Ivan',3,5,'2022-05-11',35,6,'true',50,'STREET','Ivan',18,810)";
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("Value inserted successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createTable(){
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = "CREATE TYPE VIEW AS ENUM ('BAD', 'TERRIBLE', 'PARK', 'STREET');" +
                    "CREATE TABLE collection(id SERIAL PRIMARY KEY, " +
                    "Name VARCHAR(200), " +
                    "CoordinateX INTEGER," +
                    "CoordinateY INTEGER," +
                    "CreationTime DATE, " +
                    "Area VARCHAR(200), " +
                    "NumberOfRooms INTEGER, " +
                    "Furniture BOOLEAN," +
                    "TimeToMetroOnFoot INTEGER," +
                    "View VARCHAR(200)," +
                    "NameH VARCHAR(200)," +
                    "Year INTEGER," +
                    "NumberOfFlatsOnFloor INTEGER)";
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("finished");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "nav461");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }
}
