package Graphs.GraphTraversal;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    private LinkedList<Integer>[] adjList;
    private int edges;
    private int vertices;

    public DepthFirstSearch(int nodes) {
        vertices = nodes;
        edges = 0 ;

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


    private static void dfs(int source, LinkedList<Integer>[] adj) {

        boolean[] visited = new boolean[5];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int u = stack.pop();

            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");

                for(int v : adj[u]) {
                    if(!visited[v]) {
                        stack.push(v);
                    }
                }
            }
        }


    }



    public static void main(String[] args) {

        DepthFirstSearch dfs = new DepthFirstSearch(5);

        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(3,0);
        dfs.addEdge(2,4);

        dfs(0, dfs.adjList);


    }

}
