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
import javax.swing.JOptionPane;

/**
 *
 * @author DileepaBandara
 */
public class CreateTBL {
    
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/openjobs";
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {}

   public void createTable() {
        Connection conn = null;
        Statement stmt = null;
                    
        try{
            System.out.println("Step 2 - Creating Tables");
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database openjobs...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database openjobs - SUCCESS !");

            stmt = conn.createStatement();

            //------------------------------------------------   path_weighted   ------------------------------------------------//
            System.out.println("Creating path_weighted table...");
            String SQLweighted_path = "CREATE TABLE path_weighted" +
                         "(pID INTEGER not NULL, " +
                         " pName VARCHAR(20), " + 
                         " pWeight INTEGER, " + 
                         " PRIMARY KEY ( pID ))"; 
            stmt.executeUpdate(SQLweighted_path);
            System.out.println("'path_weighted' table created - SUCCESS !");
            

            //------------------------------------------------   path_unweighted   ------------------------------------------------//
            System.out.println("Creating  path_unweighted table...");
            String SQLunweighted_vertex = "CREATE TABLE path_unweighted" +
                         "(pID INTEGER not NULL, " +
                         " pName VARCHAR(20), " + 
                         " pVertex INTEGER, " + 
                         " PRIMARY KEY ( pID ))";
            stmt.executeUpdate(SQLunweighted_vertex);
            System.out.println("'path_unweighted' table created - SUCCESS !");
            
            
            //------------------------------------------------   admin   ------------------------------------------------//
            System.out.println("Creating admin table...");
            String SQLadmin = "CREATE TABLE admin" +
                         "(aID VARCHAR(50) not NULL, " +
                         " aName VARCHAR(50), " + 
                         " aPassword VARCHAR(50), " + 
                         " PRIMARY KEY ( aID ))";
            stmt.executeUpdate(SQLadmin);
            System.out.println("'admin' table created - SUCCESS !");
            
            
            //------------------------------------------------   project   ------------------------------------------------//
            System.out.println("Creating project table...");
            String SQLproject = "CREATE TABLE project" +
                         "(pID VARCHAR(50) not NULL, " +
                         " pName VARCHAR(255), " + 
                         " pDays int(255), " + 
                         " PRIMARY KEY ( pID ))";
            stmt.executeUpdate(SQLproject);
            System.out.println("'project' table created - SUCCESS !");

   
             //--------------------------------------   upcoming_projects   -----------------------------------------//
            System.out.println("Creating upcoming_projects table...");
            String SQLupcoming_projects = "CREATE TABLE upcoming_projects" +
                         "(pID VARCHAR(50) not NULL, " +
                         " pName VARCHAR(255), " + 
                         " pDays int(255), " + 
                         " PRIMARY KEY ( pID ))";
            stmt.executeUpdate(SQLupcoming_projects);
            System.out.println("'upcoming_projects' table created - SUCCESS !");
            
            
            System.out.println("Step 2 DONE!");
           
            }   catch(SQLException se){
                 se.printStackTrace();
            }   catch(Exception e){
                e.printStackTrace();
            }  finally{
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
             System.out.println("Jump to Step 3");
            
            insertData();
    }

   private static void insertData() {
        Connection conn = null;
        Statement stmt = null;
        APWGenerator apw = new APWGenerator();
        String result[] = apw.adminPWGenerate();
   
        try{
            System.out.println("Step 3 - Inserting Data");
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database openjobs...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database openjobs - SUCCESS !");

            stmt = conn.createStatement();

            //------------------------------------------------   path_weighted   ------------------------------------------------//
            System.out.println("Inserting data into path_weighted table... ");
            String SQLweighted_path = "INSERT INTO path_weighted VALUES "
                    + "(1, 'S0S0', 0 ), (2, 'S0S1', 30), (3, 'S0S2', 20), (4, 'S0S3', 0), (5, 'S0S4', 0), (6, 'S0S5', 60),"
                    + "(7, 'S1S0', 40 ), (8, 'S1S1', 0), (9, 'S1S2', 50), (10, 'S1S3', 50), (11, 'S1S4', 0), (12, 'S1S5', 30),"
                    + "(13, 'S2S0', 80 ), (14, 'S2S1', 20), (15, 'S2S2', 0), (16, 'S2S3', 50), (17, 'S2S4', 0), (18, 'S2S5', 90),"
                    + "(19, 'S3S0', 0 ), (20, 'S3S1', 50), (21, 'S3S2', 55), (22, 'S3S3', 0), (23, 'S3S4', 40), (24, 'S3S5', 50),"
                    + "(25, 'S4S0', 0 ), (26, 'S4S1', 0), (27, 'S4S2', 90), (28, 'S4S3', 40), (29, 'S4S4', 0), (30, 'S4S5', 0),"
                    + "(31, 'S5S0', 60 ), (32, 'S5S1', 0), (33, 'S5S2', 90), (34, 'S5S3', 50), (35, 'S5S4', 0), (36, 'S5S5', 0)";
            stmt.executeUpdate(SQLweighted_path); 
            System.out.println("Data inserted to path_weighted table - SUCCESS !");
            

            //------------------------------------------------   path_unweighted   ------------------------------------------------//
            System.out.println("Inserting data into path_unweighted table... ");
            String SQLunweighted_vertex = "INSERT INTO path_unweighted VALUES "
                    + "(1, 'S0V1', 1 ), (2, 'S0V2', 3), (3, 'S1V1', 2), (4, 'S1V2', 5), (5, 'S2V1', 6),"
                    + "(6, 'S2V2', 4 ), (7, 'S3V1', 6), (8, 'S3V2', 7), (9, 'S4V1', 5), (10, 'S4V2', 6), "
                    + "(11, 'S5V1', 7 ), (12, 'S5V2', 8), (13, 'S6V1', 0), (14, 'S6V2', 8), (15, 'S7V1', 3), "
                    + "(16, 'S7V2', 1 ), (17, 'S8V1', 6), (18, 'S8V2', 4), (19, 'S9V1', 7), (20, 'S9V2', 8) ";
            stmt.executeUpdate(SQLunweighted_vertex); 
            System.out.println("Data inserted to path_unweighted table - SUCCESS !");
            
            
            //------------------------------------------------   admin   ------------------------------------------------//
            System.out.println("Inserting data into admin table... ");
            String p1 = result[0];
            String SQLadmin1 = String.format("INSERT INTO admin VALUES ('%s', '%s', '%s')", "a001", "Dileepa", p1);
            String SQLadmin6 = String.format("INSERT INTO admin VALUES ('%s', '%s', '%s')", "guest", "guest", "guest");
            stmt.executeUpdate(SQLadmin1);
            stmt.executeUpdate(SQLadmin6);
            System.out.println("Data inserted to admin table - SUCCESS !");
            
            
            //------------------------------------------------   project   ------------------------------------------------//
            System.out.println("Inserting data into project  table... ");
            String SQLproject = "INSERT INTO project VALUES "
                    + "('p001', 'Project 001', 11 ), ('p002', 'Project 002', 31), ('p003', 'Project 003', 12), ('p004', 'Project 004', 15), ('p005', 'Project 005', 16),"
                    + "('p006', 'Project 006', 41 ), ('p007', 'Project 007', 61), ('p008', 'Project 008', 17), ('p009', 'Project 009', 55), ('p010', 'Project 010', 26), "
                    + "('p011', 'Project 011', 17 ), ('p012', 'Project 012', 81), ('p013', 'Project 013', 10), ('p014', 'Project 014', 38), ('p015', 'Project 015', 33), "
                    + "('p016', 'Project 016', 19 ), ('p017', 'Project 017', 64), ('p018', 'Project 018', 14), ('p019', 'Project 019', 17), ('p020', 'Project 020', 48) ";
            stmt.executeUpdate(SQLproject); 
            System.out.println("Data inserted to project table - SUCCESS !");
          
            
            //----------------------------------------   upcoming_projects   -----------------------------------------//
            System.out.println("Inserting data into upcoming_projects  table... ");
            String SQLupcoming_projects= "INSERT INTO upcoming_projects VALUES "
                    + "('p021', 'Project 021', 141 ), ('p022', 'Project 022', 132), ('p023', 'Project 023', 124), ('p024', 'Project 024', 152), ('p025', 'Project 025', 116),"
                    + "('p026', 'Project 026', 167 ), ('p027', 'Project 027', 161), ('p028', 'Project 028', 174), ('p029', 'Project 029', 155), ('p030', 'Project 030', 126) ";
            stmt.executeUpdate(SQLupcoming_projects); 
            System.out.println("Data inserted to upcoming_projects table - SUCCESS !");
            
            
            System.out.println("Step 3 DONE!");
            System.out.println("All steps completed successfully!");
            String successMessage = "All steps completed successfully!\nDatabase and all the tables are created successfully!."
                    + "\nCreated database = openjobs"
                    + "\nCreated tables = path_unweighted, path_weighted, project, upcoming_projects, admin";
            JOptionPane.showMessageDialog(null, successMessage, "Database Created Success! ", JOptionPane.INFORMATION_MESSAGE);
           
        }   catch(SQLException se){
                 se.printStackTrace();
                JOptionPane.showMessageDialog(null, se, "SQL Error", JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(null, "Maybe there is another database simillar to the openjobs database", "Check Again", JOptionPane.WARNING_MESSAGE);
            }   catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }  finally{
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
         System.out.println("! ---------------------------- Process End ---------------------------- ! ");
    }
}
