package com.InsertImage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/image","root","Niraj@nr7");

            String q="insert into table1(timg) values (?);";

            PreparedStatement psm=con.prepareStatement(q);
            FileInputStream fis=new FileInputStream("Screenshot 2021-01-27 at 4.26.00 PM.png");

            psm.setBinaryStream(1,fis,fis.available());
            psm.executeUpdate();

            System.out.println("done");



        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
