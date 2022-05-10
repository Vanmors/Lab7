package com.company.Database;

import com.company.data.Flat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CollectionDB {
    public void insertIntoTable(Flat flat){
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = "INSERT INTO collaction(Name, Coordinates, Creation Time, " +
                    "Area, NumberOfRooms, Furniture, " +
                    "TimeToMetroOnFoot, View, Name, " +
                    "Year, NumberOfFlatsOnFloor) VALUES()";
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("Value inserted successfully");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
    public void createTable(){
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table = "CREATE TABLE collection(id SERIAL PRIMARY KEY, " +
                    "Name VARCHAR(200), " +
                    "Coordinates VARCHAR(200), " +
                    "Creation Time VARCHAR(200), " +
                    "Area VARCHAR(200), " +
                    "NumberOfRooms INTEGER, " +
                    "Furniture VARCHAR(200)," +
                    "TimeToMetroOnFoot INTEGER," +
                    "View VARCHAR(200)," +
                    "Name VARCHAR(200)," +
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
