package com.Select;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/youtube";
            String username="root";
            String password="Niraj@nr7";

            Connection con= DriverManager.getConnection(url,username,password);

            if(!con.isClosed())
                System.out.println("there is a connection");

            String q="select * from table1";
            Statement stmt=con.createStatement();
            ResultSet set=stmt.executeQuery(q);

            while (set.next()){
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);

                System.out.println(id+" "+name+" "+city);

            }




            System.out.println("donea");

            con.close();

        } catch (ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
    }
}
