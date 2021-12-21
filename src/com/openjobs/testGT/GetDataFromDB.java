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

package com.openjobs.testGT;
import com.mysql.jdbc.Connection;
import com.openjobs.dashboard.Dashboard;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author DileepaBandara
 */
public class GetDataFromDB {
    
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs =null;
        Statement st = null;
        public static String pminD_print = "No recorded projects available";
        public static String pmaxD_print = "No recorded projects available";
        int minDays = 0;
        int maxDays = 0;
        public static String[] arr_pmin = new String[100];
        public static String[] arr_pmax = new String[100];
        public static int totalProjects;
        public static int totalMinProjects;
        public static int totalMaxProjects;
    

        // PathWeighted Table
        public static int[] path_weighted(){
            
                int[] pWeightArray = new int[40];

                try {
                    Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                    Statement s = conn.createStatement ();
                    s.executeQuery ("SELECT pID, pName, pWeight FROM path_weighted");
                    ResultSet rs = s.getResultSet ();
                    int count = 0;

                    while (rs.next ())
                    {
                        int pID = rs.getInt ("pID");
                        String pName = rs.getString ("pName");
                        int pWeight = rs.getInt ("pWeight");
                        pWeightArray[count] = pWeight;
                        ++count;               
                    }

                    System.out.println("pWeightArray: " + Arrays.toString(pWeightArray));
                    rs.close ();
                    s.close ();
                    System.out.println (count + " paths were retrieved");

                } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
               }

               return pWeightArray;
               
        }

        // PathUnweighted Table
        public static int[] path_unweighted(){

                int[] vNoArray = new int[40];

                try {
                    Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                    Statement s = conn.createStatement ();
                    s.executeQuery ("SELECT pID, pName, pVertex FROM path_unweighted");
                    ResultSet rs = s.getResultSet ();
                    int count = 0;

                    while (rs.next ())
                    {
                        int vID = rs.getInt ("pID");
                        String vName = rs.getString ("pName");
                        int vNo = rs.getInt ("pVertex");
                        vNoArray[count] = vNo;
                        ++count;               
                    }

                    System.out.println("vNoArray: " + Arrays.toString(vNoArray));
                    rs.close ();
                    s.close ();
                    System.out.println (count + " v numbers were retrieved");

                } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
               }

               return vNoArray;

        }
        
        // Project Table
        public static Object[] projectDays(){
        
            String[] projectID = new String[100];
            String[] projectName = new String[100];
            int[] projectDays = new int[100];
            
            try {
                    Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                    Statement s = conn.createStatement ();
                    
                    String query = "SELECT COUNT(*) FROM project";
                    ResultSet rs1 = s.executeQuery(query);
                    rs1.next();
                    totalProjects = rs1.getInt(1);
                    System.out.println("Number of projects in the table: "+totalProjects);
                    projectID = new String[totalProjects];
                    projectName = new String[totalProjects];
                    projectDays = new int[totalProjects];
            
                    
                    s.executeQuery ("SELECT pID, pName, pDays FROM project");
                    ResultSet rs = s.getResultSet ();
                    
                    int count = 0;

                    while (rs.next ())
                    {
                        String pID = rs.getString ("pID");
                        String pName = rs.getString ("pName");
                        int pDays = rs.getInt ("pDays");
                        
                        projectID[count] = pID;
                        projectName[count] = pName;
                        projectDays[count] = pDays;
       
                        ++count;               
                    }
     
                    rs.close ();
                    s.close ();

                } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
               }

               return new Object[]{projectID, projectName, projectDays};
        
        }
        
        // Project Table Min Max Days Return
        public void minMax_days(int minDaysR, int maxDaysR){
     
            int countMin = 0; 
            int countMax = 0;
            
            minDays = minDaysR;
            maxDays = maxDaysR;

            System.out.println("Min Days: " +minDays );
            System.out.println("Max Days: " +maxDays );
            
             try {
                    conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                    st = conn.createStatement ();
                    
                    //--------------------------------------------------------------Min Days Projects --------------------------------------------------------------//
                    String q1 = "SELECT COUNT(*) FROM project WHERE pDays= '"+minDays+"' ";
                    ResultSet rs1 = st.executeQuery(q1);
                    rs1.next();
                    totalMinProjects = rs1.getInt(1);
                    arr_pmin = new String[totalMinProjects];
 
                    
                    String query1 = "SELECT pID, pName, pDays FROM project WHERE pDays= '"+minDays+"' ";
                    st = conn.createStatement ();
                    rs = st.executeQuery(query1);        
                      
                    while (rs.next()) {
                        String pMInDays_pID = rs.getString("pID");
                        String pMInDays_pName = rs.getString("pName");
                        int pMInDays_pDays = rs.getInt("pDays");
                        pminD_print = "Project ID = " +pMInDays_pID + "\nProject Name = " +pMInDays_pName + "\nProject Remaining Days = " +pMInDays_pDays +"\n";
                        
                        arr_pmin[countMin] = pminD_print;
                        
                        ++countMin;
                     }
               
                    
                    //--------------------------------------------------------------Max Days Projects --------------------------------------------------------------//
                    String q2 = "SELECT COUNT(*) FROM project WHERE pDays= '"+maxDays+"' ";
                    ResultSet rs2 = st.executeQuery(q2);
                    rs2.next();
                    totalMaxProjects = rs2.getInt(1);
                    arr_pmax = new String[totalMaxProjects];
                    
                    String query2 = "SELECT pID, pName, pDays FROM project WHERE pDays= '"+maxDays+"' ";
                    st = conn.createStatement ();
                    rs = st.executeQuery(query2);
                    
                    while (rs.next()) {
                        String pMaxDays_pID = rs.getString("pID");
                        String pMaxDays_pName = rs.getString("pName");
                        int pMaxDays_pDays = rs.getInt("pDays");
                        pmaxD_print = "Project ID = " +pMaxDays_pID + "\nProject Name = " +pMaxDays_pName + "\nProject Remaining Days = " +pMaxDays_pDays +"\n";
                        
                        arr_pmax[countMax] = pmaxD_print;
                        
                        ++countMax;
                     }

                    rs.close ();
                    st.close ();
                    
                } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
               }
        
        }
    
        // UpcomingProject Table
        public static Object[] upcomingProjects(){
            String[] projectName = new String[100];
            try {
                    Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                    Statement s = conn.createStatement ();
                    
                    String query = "SELECT COUNT(*) FROM upcoming_projects";
                    ResultSet rs1 = s.executeQuery(query);
                    rs1.next();
                    totalProjects = rs1.getInt(1);
                    System.out.println("Number of up coming upcoming_projects in the table: "+totalProjects);
                    projectName = new String[totalProjects];
                    
                    s.executeQuery ("SELECT pID, pName, pDays FROM upcoming_projects");
                    ResultSet rs = s.getResultSet ();
                    
                    int count = 0;

                    while (rs.next ())
                    {
                        String pName = rs.getString ("pName");                         
                        projectName[count] = pName;
                        
                        ++count;               
                    }
     
                    rs.close ();
                    s.close ();

                } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
               }
        
            return new Object[]{totalProjects, projectName};
        }
        
        public static void main(String[] args) { } 
    
}
