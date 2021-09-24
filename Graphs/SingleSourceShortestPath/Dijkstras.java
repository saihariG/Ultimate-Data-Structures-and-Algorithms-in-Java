package Graphs.SingleSourceShortestPath;

import java.util.Arrays;

// (single source) shortest path algorithm
public class Dijkstras {

    private static int[] distance;

    private static int[][] adj ;
    private static int vertices; // vertices
    private static int edges; // Edges
    private static boolean[] visited ;

    public Dijkstras(int nodes) {
        vertices = nodes;
        edges = 0;
        adj = new int[nodes][nodes];
        visited = new boolean[vertices];

        distance = new int[nodes];
        for(int i = 0 ; i  < nodes ; i++) {
            distance[i] = 999; // infinity
        }

    }

    private static void addEdge(int u , int v , int w) {

        adj[u][v] = w;
        adj[v][u] = w;
        edges++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(vertices).append("vertices ").append(edges).append("edges ").append("\n");
        for(int v = 0; v < vertices; v++) {
            sb.append(v).append(": ");
            for(int w : adj[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static int pickMin() {
        int min = Integer.MAX_VALUE;
        int minNode = -1;

        for(int i = 0 ; i < distance.length ; i++) {
               if(distance[i] < min && !visited[i]) {
                   min = distance[i];
                   minNode = i;
               }
        }
        return minNode;
    }

    private static void dijikstras(int source) {

        distance[source] = 0;

        for(int i = 0 ; i < vertices - 1 ; i++) {

            int u = pickMin();
            visited[u] = true;

            for (int j = 0 ; j < vertices; j++) {

                   if (adj[u][j] !=  0 && (distance[u] + adj[u][j] < distance[j]) && !visited[j]) {
                        distance[j] = distance[u] + adj[u][j];
                   }
            }

        }
    }


    public static void main(String[] args) {

        Dijkstras dijkstras =  new Dijkstras(9);

        addEdge(0,1,4);
        addEdge(0,4,8);
        addEdge(1,4,11);
        addEdge(1,2,8);
        addEdge(2,8,2);
        addEdge(2,3,7);
        addEdge(2,6,4);
        addEdge(3,6,14);
        addEdge(3,7,9);
        addEdge(4,5,1);
        addEdge(4,8,7);
        addEdge(5,6,2);
        addEdge(5,8,6);
        addEdge(6,7,10);

        System.out.println(dijkstras);
        dijikstras(0);

        System.out.println(Arrays.toString(distance));

    }

}
