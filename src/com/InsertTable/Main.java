package com.InsertTable;

import com.mysql.cj.jdbc.ConnectionImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/youtube";
            String username="root";
            String password="Niraj@nr7";

            Connection con= DriverManager.getConnection(url,username,password);

            if(con.isClosed()){
                System.out.println("connection is closed");

            }
            else{
                System.out.println("Connection is made");
            }

            String q="create table table1(tid int(20) primary key auto_increment, tname varchar(200) not null,tcity varchar(100));";
            String x="CREATE DATABASE yt";
            Statement stm=con.createStatement();
            stm.executeUpdate(x);
            stm.executeUpdate(q);
            System.out.println("Table has been cerated");

            con.close();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
