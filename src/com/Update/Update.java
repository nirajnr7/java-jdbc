package com.Update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/youtube";
            String username="root";
            String password="Niraj@nr7";

            Connection con= DriverManager.getConnection(url,username,password);

            if(!con.isClosed())
                System.out.println("there is a connection");

            String q="update table1 set tname=? , tcity=? where tid=? ;";

            BufferedReader br=new BufferedReader(new InputStreamReader( System.in));

            System.out.println("enter name");
            String name=br.readLine();
            System.out.println("enter city");
            String city=br.readLine();
            System.out.println("enter id");
            int id=Integer.parseInt(br.readLine());

            PreparedStatement psm=con.prepareStatement(q);

            psm.setString(1,name);
            psm.setString(2,city);
            psm.setInt(3,id);

            psm.executeUpdate();


            System.out.println("donea");

            con.close();

        } catch (ClassNotFoundException | SQLException | IOException e ) {
            e.printStackTrace();
        }



    }
}
