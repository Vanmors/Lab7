//package com.company.Database;
//
//import com.company.data.Flat;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class CollectionDB {
//    public void insertIntoTable(){
//        Connection connection = null;
//        Statement statement = null;
//        CollectionDB connectionDB = new CollectionDB();
//
//        connection = connectionDB.getConnection();
//
//        try {
//            String firstFlat = "INSERT INTO collection(Name, CoordinateX, CoordinateY, CreationTime, " +
//                    "Area, NumberOfRooms, Furniture, " +
//                    "TimeToMetroOnFoot, View, NameH, " +
//                    "Year, NumberOfFlatsOnFloor) VALUES('Ivan',3,5,'2022-05-11',35,6,'true',50,'STREET','Ivan',18,810)";
//            String secondFlat = "INSERT INTO collection(Name, CoordinateX, CoordinateY, CreationTime, " +
//                    "Area, NumberOfRooms, Furniture, " +
//                    "TimeToMetroOnFoot, View, NameH, " +
//                    "Year, NumberOfFlatsOnFloor) VALUES('Roman',43,41,'2022-05-12',78,3,'false',50,'BAD','Roman',23,400)";
//            String thirdFlat = "INSERT INTO collection(Name, CoordinateX, CoordinateY, CreationTime, " +
//                    "Area, NumberOfRooms, Furniture, " +
//                    "TimeToMetroOnFoot, View, NameH, " +
//                    "Year, NumberOfFlatsOnFloor) VALUES('Sergey',5,7,'2022-05-12',56,8,'true',50,'TERRIBLE','Sergey',45,230)";
//            statement = connection.createStatement();
//            statement.executeUpdate(firstFlat);
//            statement.executeUpdate(secondFlat);
//            statement.executeUpdate(thirdFlat);
//            System.out.println("Value inserted successfully");
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void clearTable() {
//        Connection connection = null;
//        Statement statement = null;
//        CollectionDB connectionDB = new CollectionDB();
//
//        connection = connectionDB.getConnection();
//
//        try {
//            String table = "DELETE FROM collection";
//            statement = connection.createStatement();
//            statement.executeUpdate(table);
//            System.out.println("finished");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
