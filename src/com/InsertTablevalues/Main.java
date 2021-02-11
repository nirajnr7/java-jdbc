package com.InsertTablevalues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            String q="insert into table1(tname,tcity) values (?,?)";

            PreparedStatement psm=con.prepareStatement(q);

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter name");
            String name=br.readLine();
            System.out.println("enter name");
            String city=br.readLine();

            psm.setString(1,name);
            psm.setString(2,city);

            psm.executeUpdate();



            con.close();

        } catch (ClassNotFoundException | SQLException | IOException e ) {
            e.printStackTrace();
        }



    }
}
