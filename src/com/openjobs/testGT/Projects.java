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

/**
 *
 * @author DileepaBandara
 */
public class Projects {
    
    public String pID, pName;
    public int pDays;
    
    public Projects(String pID, String pName, int pDays){
    
        this.pID = pID;
        this.pName = pName;
        this.pDays = pDays;
    }
    
    public String getpID(){
        return pID; 
    }
    
    public String getpName(){
        return pName; 
    }
    
    public int getpDays(){
        return pDays; 
    }
}
