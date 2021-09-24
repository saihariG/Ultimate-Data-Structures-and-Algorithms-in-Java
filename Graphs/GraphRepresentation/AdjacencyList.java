package Graphs.GraphRepresentation;

import java.util.LinkedList;

public class AdjacencyList {


    private LinkedList<Integer>[] adj ;
    private int V; // vertices
    private int E; // Edges

    public AdjacencyList(int nodes) {
        V = nodes;
        E = 0;
        adj = new LinkedList[nodes];
        for (int i = 0 ; i < nodes ; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int u , int v) {
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(V).append("vertices ").append(E).append("edges ").append("\n");
        for(int v = 0 ; v < V ; v++) {
            sb.append(v).append(": ");
            for(int w : adj[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        AdjacencyList adjacencyList = new AdjacencyList(4);

        adjacencyList.addEdge(0,1);
        adjacencyList.addEdge(1,2);
        adjacencyList.addEdge(2,3);
        adjacencyList.addEdge(3,0);

        System.out.println(adjacencyList);
    }



}
