package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/","root","Niraj@nr7");

            if(con.isClosed())
                System.out.println("closed");
            else
                System.out.println("open");

            con.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
