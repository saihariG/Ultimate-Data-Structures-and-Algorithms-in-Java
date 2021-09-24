package Graphs.GraphTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private LinkedList<Integer>[] adjList;
    private int vertices;
    private int edges;

    public BreadthFirstSearch(int nodes) {
        vertices = nodes;
        edges = 0;

        adjList = new LinkedList[nodes];

        for(int i = 0 ; i < nodes ; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u , int v) {

        adjList[u].add(v);
        adjList[v].add(u);
        edges++;
    }


    private static void bfs(int source,LinkedList<Integer>[] adj) {

        boolean[] visited = new boolean[adj.length];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            for(int V : adj[u]) {
                 if(!visited[V]) {
                     visited[V] = true;
                     queue.offer(V);
                 }
            }
        }

    }


    public static void main(String[] args) {

        BreadthFirstSearch bfs = new BreadthFirstSearch(5);

        bfs.addEdge(0,1);
        bfs.addEdge(1,2);
        bfs.addEdge(2,3);
        bfs.addEdge(3,0);
        bfs.addEdge(2,4);


        bfs(0, bfs.adjList);


    }


}
