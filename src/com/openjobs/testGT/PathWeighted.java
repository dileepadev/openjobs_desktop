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

import java.util.Arrays;

/**
 *
 * @author DileepaBandara
 */
public class PathWeighted {

     int source = 0;
     public static int uwS = 0;
     public static int[] uwD = new int[6];
     public static int[] uwT = new int[6];
    
    
    public static void dijkstra(int[][] graph, int sourceVertex){
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0; 
        for (int i = 0; i < vertexCount; i++){
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;
            for (int v =0 ; v < vertexCount; v++){
                if(!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])){
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
       System.out.println("Source\t\t" + "Destination\t\t" + "Traffic");
        for (int i = 0; i < distance.length; i++){
            String sOutput = sourceVertex + " \t\t " + i + " \t\t\t "  + distance[i];
            System.out.println(sOutput); 
             uwS = sourceVertex;
             uwD[i] = i;
             uwT[i] = distance[i];
        }

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

     public void weightedLocation(int weightedLocationSource){
        
        source = weightedLocationSource;
        System.out.println("Weighted Location Source: " + "Server " + source);
        System.out.println("Connecting to the database...");
        
        weightedPath(source);
        
    }
     
     public static void weightedPath(int s){

        int source = s;
        int result[] = new GetDataFromDB().path_weighted();


         int graph[][] = new int[][] { 
                 { result[0], result[1], result[2], result[3], result[4], result[5] },
                 { result[6], result[7], result[8], result[9], result[10], result[11] },
                 { result[12], result[13], result[14], result[15], result[16], result[17] },
                 { result[18], result[19], result[20], result[21], result[22], result[23] },
                 { result[24], result[25], result[26], result[27], result[28], result[29] },
                 { result[30], result[31], result[32], result[33], result[34], result[35] },
         };

         PathWeighted t = new PathWeighted();
         t.dijkstra(graph, source);
     
     }
    
    public static void main(String[] args) {}
    
}