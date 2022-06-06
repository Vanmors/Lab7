package com.company.Database;

import com.company.data.Coordinates;
import com.company.data.Flat;
import com.company.data.House;
import com.company.data.View;

import java.sql.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Stack;
import java.util.stream.Collectors;

public class ParseDB {

    public void parse(Stack<Flat> stack) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        CollectionDB connectionDB = new CollectionDB();

        connection = connectionDB.getConnection();
        try {
            String table = "SELECT * FROM collection ";
            statement = connection.createStatement();
            rs = statement.executeQuery(table);

            while (rs.next()) {
                Coordinates coordinates = new Coordinates(rs.getInt(3), rs.getLong(4));
                House house = new House(rs.getString(11), rs.getInt(12), rs.getInt(13));
                Timestamp t = rs.getTimestamp(5); ZonedDateTime zdt = t.toInstant().atZone(ZoneId.of("Europe/Moscow"));
                Flat flat = new Flat(rs.getInt(1),
                        rs.getString(2),
                        coordinates,
                        zdt,
                        rs.getInt(6),
                        rs.getLong(7),
                        rs.getBoolean(8),
                        rs.getLong(9),
                        View.valueOf((String) rs.getObject(10)),
                        house,
                        rs.getString(14));

                }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
