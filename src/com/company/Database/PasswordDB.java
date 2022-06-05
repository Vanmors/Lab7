package com.company.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PasswordDB {
    private String login;
    private String password;

    public PasswordDB(String login, String password ){
        this.login = login;
        this.password = password;
    }
    public void createPasswordTable(){
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String table =
                    "CREATE TABLE IF NOT EXISTS passwords(id SERIAL PRIMARY KEY, " +
                    "Login VARCHAR(200)," +
                    "Password VARCHAR(200))";
            statement = connection.createStatement();
            statement.executeUpdate(table);
            System.out.println("finishedBD");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void insertIntoTable(){
        Connection connection = null;
        Statement statement = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();

        try {
            String thirdFlat = "INSERT INTO passwords(Login, Password) VALUES" +
                    "(" + "\'" + login+ "\'" + " , " + "\'" + password + "\'"  + ")";
            statement = connection.createStatement();
            statement.executeUpdate(thirdFlat);
            System.out.println("Value inserted successfully");
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