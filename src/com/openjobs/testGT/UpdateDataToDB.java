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
public class UpdateDataToDB {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    int dialogButton2 = JOptionPane.INFORMATION_MESSAGE;
    
    public void update_tbl_path_weighted(String pName, int pWeight){
    
         try {            
                Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                String query = "UPDATE path_weighted SET pWeight =? WHERE pName=?";
                pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, pWeight);
                pstmt.setString(2, pName);
                pstmt.executeUpdate();
                
                System.out.println("pName - " + pName +"\n"+ "pWeight - " + pWeight);
                JOptionPane.showMessageDialog(null, "Weight Updated!", "Update Weight", dialogButton2);
                new Dashboard().setReceiveData();
         
         } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
         }

    }
    
    public void update_tbl_path_unweighted(String pName, int pVertex){
    
        try {            
                Connection conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/openjobs", "root", "");
                String query = "UPDATE path_unweighted SET pVertex =? WHERE pName=?";
                pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, pVertex);
                pstmt.setString(2, pName);
                pstmt.executeUpdate();
                
                System.out.println("pName - " + pName +"\n"+ "pVertex - " + pVertex);
                JOptionPane.showMessageDialog(null, "Weight Updated!", "Update Weight", dialogButton2);
                new Dashboard().setSendData();
         
         } catch (SQLException ex) {
                   System.out.println("Error: " + ex);
         }
        
    }
    
}
