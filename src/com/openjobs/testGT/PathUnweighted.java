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

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

/**
 *
 * @author DileepaBandara
 */
public class PathUnweighted { 
    
    public static int int_shortest_path_length = 0;
    public static String string_shortest_path_length = "0";
    public static String[] shortest_path;
    public static String[] emptyArray = {"0"};
    public static String sp = "0";
    
    public void unWeightedLocation(int s, int d){
        
        System.out.println("Weighted Location Source: " + "Server " + s);
        System.out.println("Weighted Location Destination: " + "Server " + d);
        System.out.println("Connecting to the database...");
        
        unweightedPath(s, d);
        
    }
    
    public static void unweightedPath(int s, int d){
    
        int source = s ; 
        int dest = d; 
        
        int v = 10; 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v); 
        for (int i = 0; i < v; i++) { 
                adj.add(new ArrayList<Integer>()); 
        } 

        int result[] = new GetDataFromDB().path_unweighted();

        addEdge(adj, 0, result[0]);         // 0=start, 1=end
        addEdge(adj, 0, result[1]); 
        addEdge(adj, 1, result[2]);
        addEdge(adj, 1, result[3]);
        addEdge(adj, 2, result[4]);
        addEdge(adj, 2, result[5]);
        addEdge(adj, 3, result[6]); 
        addEdge(adj, 3, result[7]); 
        addEdge(adj, 4, result[8]); 
        addEdge(adj, 4, result[9]); 
        addEdge(adj, 5, result[10]); 
        addEdge(adj, 5, result[11]); 
        addEdge(adj, 6, result[12]);
        addEdge(adj, 6, result[13]);
        addEdge(adj, 7, result[14]);
        addEdge(adj, 7, result[15]);
        addEdge(adj, 8, result[16]);
        addEdge(adj, 8, result[17]);
        addEdge(adj, 9, result[18]); 
        addEdge(adj, 9, result[19]);

        printShortestDistance(adj, source, dest, v);
    
    }
    
    public static void main(String args[]) { } 

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) { 
        adj.get(i).add(j); 
        adj.get(j).add(i); 
    } 
 
    private static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int s, int dest, int v) { 

            int pred[] = new int[v]; 
            int dist[] = new int[v]; 

            if (BFS(adj, s, dest, v, pred, dist) == false) { 
                    System.out.println("Given source and destination are not connected"); 
                    string_shortest_path_length = "0";
                    shortest_path = emptyArray;
                    return; 
            } 

            LinkedList<Integer> path = new LinkedList<Integer>(); 
            int crawl = dest; 
            path.add(crawl); 
            while (pred[crawl] != -1) { 
                    path.add(pred[crawl]); 
                    crawl = pred[crawl]; 
            } 

            int_shortest_path_length =  dist[dest];
            string_shortest_path_length = String.valueOf(int_shortest_path_length);
            System.out.println("Shortest path length = " +int_shortest_path_length); 

            shortest_path = new String[int_shortest_path_length+1];
            System.out.print("Path = "); 
            for (int i = path.size() - 1; i >= 0; i--) { 
                    sp = path.get(i) + " ";
                    shortest_path[i] = path.get(i).toString();
                    System.out.print(sp); 
            } 
            System.out.println("\nArray: " + Arrays.toString(shortest_path));
            Collections.reverse(Arrays.asList(shortest_path));
            System.out.println("Reverse Array: " + Arrays.asList(shortest_path)); 
    } 

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]) { 

            LinkedList<Integer> queue = new LinkedList<Integer>(); 

            boolean visited[] = new boolean[v]; 

            for (int i = 0; i < v; i++) { 
                    visited[i] = false; 
                    dist[i] = Integer.MAX_VALUE; 
                    pred[i] = -1; 
            } 

            visited[src] = true; 
            dist[src] = 0; 
            queue.add(src); 

            while (!queue.isEmpty()) { 
                    int u = queue.remove(); 
                    for (int i = 0; i < adj.get(u).size(); i++) { 
                            if (visited[adj.get(u).get(i)] == false) { 
                                    visited[adj.get(u).get(i)] = true; 
                                    dist[adj.get(u).get(i)] = dist[u] + 1; 
                                    pred[adj.get(u).get(i)] = u; 
                                    queue.add(adj.get(u).get(i)); 

                                    if (adj.get(u).get(i) == dest) 
                                            return true; 
                            } 
                    } 
            } 
            return false; 
    } 
    
} 
