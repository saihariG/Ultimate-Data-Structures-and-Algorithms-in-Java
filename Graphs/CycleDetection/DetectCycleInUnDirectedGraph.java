package Graphs.CycleDetection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// using breadth first search
public class DetectCycleInUnDirectedGraph {

    static LinkedList<Integer>[] adjList;
    static int[] flag;
    static int vertices;
    static int edges;

    public DetectCycleInUnDirectedGraph(int nodes) {
        vertices = nodes;
        edges = 0;

        flag = new int[nodes];
        // initially every node is unvisited
        for(int i = 0 ; i < nodes ; i++) {
            flag[i] = -1;
        }

        adjList = new LinkedList[nodes];
        for (int i = 0 ; i  < nodes ; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    public void addEdge(int u,int v) {
        adjList[u].add(v);
        adjList[v].add(u);
        edges++;
    }


    public boolean detectCycle(int source) {

        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);
        Queue<Integer> queue = new LinkedList<>();

        // enqueue the source into queue and mark it as visited
        queue.offer(source);
        visited[source] = true;
        // since the node is in the queue
        flag[source] = 0;


        while (!queue.isEmpty()) {
            int u = queue.poll();
            flag[u] = 1; // since we will visit every adjacent nodes

            for(int v : adjList[u]) {

                if(flag[v] == 0) {
                    return true;
                }

                if (!visited[v])
                {
                    visited[v] = true;
                    queue.offer(v);
                    flag[v] = 0;
                }

            }

        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(vertices).append("vertices ").append(edges).append("edges ").append("\n");
        for(int v = 0 ; v < vertices ; v++) {
            sb.append(v).append(": ");
            for(int w : adjList[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        DetectCycleInUnDirectedGraph detectUndirected = new DetectCycleInUnDirectedGraph(5);

        detectUndirected.addEdge(0,1);
        detectUndirected.addEdge(0,2);
        detectUndirected.addEdge(1,3);
        detectUndirected.addEdge(1,4);
        detectUndirected.addEdge(3,4);


        System.out.println(detectUndirected);

        System.out.println(detectUndirected.detectCycle(0));


    }

}
