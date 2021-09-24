package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TopologicalOrdering {

    private static LinkedList<Integer>[] adjList;
    private static int vertices;
    private int edges;

    private static Queue<Integer> queue;
    private static int[] inDegree;

    public TopologicalOrdering(int nodes) {
        vertices = nodes;
        edges = 0;
        adjList = new LinkedList[nodes];
        for (int i = 0 ; i < nodes ; i++) {
            adjList[i] = new LinkedList<>();
        }

        queue = new LinkedList<>();
        inDegree = new int[nodes];
    }

    // since it's a directed graph
    private void addEdge(int u , int v) {
        adjList[u].add(v);
        edges++;
        inDegree[v]++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(vertices).append("vertices ").append(edges).append("edges ").append("\n");
        for(int v = 0; v < vertices; v++) {
            sb.append(v).append(": ");
            for(int w : adjList[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void topologicalOrdering() {
        for(int i = 0 ; i < vertices ; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for(int v : adjList[u]) {
                inDegree[v]--;

                if(inDegree[v] == 0) {
                    queue.offer(v);
                }
            }

        }

    }

    public static void main(String[] args) {

        TopologicalOrdering topologicalOrdering = new TopologicalOrdering(5);

        topologicalOrdering.addEdge(0,1);
        topologicalOrdering.addEdge(0,3);
        topologicalOrdering.addEdge(1,3);
        topologicalOrdering.addEdge(1,2);
        topologicalOrdering.addEdge(3,2);
        topologicalOrdering.addEdge(3,4);

        System.out.println(topologicalOrdering);
        topologicalOrdering();

    }


}
