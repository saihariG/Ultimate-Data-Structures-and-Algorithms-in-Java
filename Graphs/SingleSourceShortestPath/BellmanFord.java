package Graphs.SingleSourceShortestPath;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// single source shortest path algorithm
public class BellmanFord {

    static class edgePair {
        int from;
        int to;
        int weight;

        public edgePair(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

    }

    private static int[] distance;


    private static int vertices; // vertices
    private static int edges; // Edges

    private BellmanFord(int nodes) {
        vertices = nodes;
        edges = 0;

        distance = new int[nodes];
        for(int i = 0 ; i  < nodes ; i++) {
            distance[i] = 999; // infinity
        }

    }

    private static void bellmanFord(int source,List<edgePair> edgeList) {


        distance[source] = 0;	//start node has value=0 to get picked 1st

        // To detect negative edge cycle
        boolean updated = false;
        //Include (V-1) edges to cover all V-vertices
        for(int i = 0 ; i< vertices-1 ; i++)
        {
            updated = false;
            for(int j = 0 ; j < edges ; j++)
            {
                edgePair pair = edgeList.get(i);

                int u = pair.from;
                int v = pair.to;
                int weight = pair.weight;

                if(distance[u] + weight < distance[v])
                {
                    distance[v] = distance[u] + weight;
                    updated = true;
                }
            }
            if(!updated)
                break;
        }

        //Now check by relaxing once more if we have a negative edge cycle
        for(int i = 0 ; i < edges ; i++)
        {
            if(updated) {
                edgePair pair = edgeList.get(i);

                int u = pair.from;
                int v = pair.to;
                int weight = pair.weight;

                if (distance[u] + weight < distance[v])
                {
                    System.out.println("Graph has -VE edge cycle\n");
                    return;
                }
            }
        }
    }


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        BellmanFord bellmanFord = new BellmanFord(vertices);

        List<edgePair> edgeList = new ArrayList<>();
        //Now input all E edges
        for (int i = 0; i < edges; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edgeList.add(new edgePair(from, to, weight));

        }

        bellmanFord(0,edgeList);
        System.out.println(Arrays.toString(distance));

    }

}
