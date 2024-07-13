package group40;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevelopJdbcDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{


    List<Developer> database = new ArrayList<>();

    Connection connection = null;
    Statement statement = null;

    System.out.println("Registration driver .....");
    Class.forName("org.h2.Driver");

    System.out.println("Creating database connection ...");
    connection = DriverManager.getConnection("jdbc:h2:mem:test","sa","");

    System.out.println("Execute statement");
    statement = connection.createStatement();

    String sqlRequest = "CREATE TABLE developers(id INT PRIMARY KEY, name VARCHAR(255), speciality VARCHAR(255), salary INT)";
    statement.execute(sqlRequest);

    //Insert data to table

        String sqlReq1 = "INSERT INTO developers VALUES(1, 'John','back-end developer',5000)";
        String sqlReq2 = "INSERT INTO developers VALUES(2, 'Bill','back-end developer',5000)";
        String sqlReq3 = "INSERT INTO developers VALUES(3, 'Robert','back-end developer',5000)";
        String sqlReq4 = "INSERT INTO developers VALUES(4, 'Ingrid','back-end developer',5000)";

        statement.execute(sqlReq1);
        statement.execute(sqlReq2);
        statement.execute(sqlReq3);
        statement.execute(sqlReq4);

        System.out.println("Receive data from database");

        ResultSet resulSet = statement.executeQuery("SELECT * FROM developers");

        while (resulSet.next()){
            System.out.println("==========");
            int id = resulSet.getInt("id");
            String name = resulSet.getString("name");
            String speciality = resulSet.getString("speciality");
            int salary = resulSet.getInt("salary");

            Developer developer = new Developer(id, name, speciality, salary);
            System.out.println(developer);
            database.add(developer);
        }

        System.out.println("Working collection: ");

        for (Developer developer : database){
            System.out.println(developer);
        }

    }
}
