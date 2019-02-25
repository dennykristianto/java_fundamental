package com.mitrais.training.Helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseBridge {
    private Connection connect = null;

    public void connect(){
        Properties prop=new Properties();
        InputStream input=null;

        try {
            String rootPath=Thread.currentThread().getContextClassLoader().getResource("").getPath();

            input = getClass().getClassLoader().getResourceAsStream("db.properties");

            // load a properties file
            if(input!=null){
                prop.load(input);
            }else{
                throw new FileNotFoundException("File not found");
            }

            connect = DriverManager.getConnection("jdbc:mysql://"+prop.getProperty("dbserver")+":3306/"+prop.getProperty("dbname")+"?useTimezone=true&serverTimezone=UTC", prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
            System.out.println("Successfully connected to the Database!");
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
