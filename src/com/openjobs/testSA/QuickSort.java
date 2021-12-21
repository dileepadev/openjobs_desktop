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

package com.openjobs.testSA;

import com.openjobs.testGT.GetDataFromDB;
import static com.openjobs.testGT.GetDataFromDB.projectDays;
import java.util.Arrays;

/**
 *
 * @author DileepaBandara
 */
public class QuickSort {
    
    int partition(int arr[], int low, int high) { 
        
        int pivot = arr[high]; 
        int i = (low-1); 

        for (int j=low; j<high; j++) { 
            if (arr[j] < pivot) { 
            i++; 
            // swap arr[i] and arr[j] 
            int temp = arr[i]; 
            arr[i] = arr[j]; 
            arr[j] = temp; 
            } 
        } 

        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 

        return i+1; 
    
    } 
    
    void sort(int arr[], int low, int high) { 
        
        if (low < high) { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 

    static void printArray(int arr[]) { 
        
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
            System.out.println(); 
    } 

    public static void getProjectDetails(){

        Object[] arrayObjects = projectDays();
//        String[] arr_projectID = (String[])arrayObjects[0];
//        String[] arr_projectName = (String[])arrayObjects[1];
        int[] arr_projectDays = (int[])arrayObjects[2];

        System.out.println("Project Days");  printArray(arr_projectDays);
        
            
        int arr[] = arr_projectDays; 
        int n = arr.length; 
        int minDays = arr[0];
        int maxDays = arr[arr.length-1];

        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 

        System.out.println("Sorted Project Days");  printArray(arr);
        
        new GetDataFromDB().minMax_days(minDays, maxDays);
  
    }
    
    public static void main(String args[]) { 
 
        getProjectDetails();
        
    }
}
