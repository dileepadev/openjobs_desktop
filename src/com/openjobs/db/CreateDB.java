/*
   --------------------------------------
      Developed by
      Dileepa Bandara
      https://dileepabandara.github.io
      contact.dileepabandara@gmail.com
      ©dileepabandara.dev
      2020
   --------------------------------------
*/

package com.openjobs.db;

import java.sql.*;

/**
 *
 * @author DileepaBandara
 */
public class CreateDB {
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER = "root";
   static final String PASS = "";
   
   public void startCreateDB(){
       
       Connection conn = null;
       Statement stmt = null;
       
        try{
            System.out.println("Step 1 - Creating Database");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to databases...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Creating database openjobs...");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE openjobs";
            stmt.executeUpdate(sql);
            System.out.println("Database 'openjobs' created - SUCCESS !");
            System.out.println("Step 1 DONE!");
           
            }   catch(SQLException se){
                se.printStackTrace();
            }   catch(Exception e){
                e.printStackTrace();
            }   finally{
                    try{
                      if(stmt!=null)
                         stmt.close();
                    } catch(SQLException se2){
                    }
                     try{
                        if(conn!=null)
                           conn.close();
                     }catch(SQLException se){
                        se.printStackTrace();
                     }
                 }
            System.out.println("Jump to Step 2");
            
            new CreateTBL().createTable();
   
   }
   
   public static void main(String[] args) {}
   
}

