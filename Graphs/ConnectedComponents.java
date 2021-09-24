package Graphs;

import java.util.LinkedList;

public class ConnectedComponents {


    private static LinkedList<Integer>[] adj ;
    private static int vertices; // vertices
    private int edges; // Edges
    private static int[] flag;

    public ConnectedComponents(int nodes) {
        vertices = nodes;
        edges = 0;
        adj = new LinkedList[nodes];
        for (int i = 0 ; i < nodes ; i++) {
            adj[i] = new LinkedList<>();
        }

        flag = new int[nodes];
    }

    private void addEdge(int u , int v) {
        adj[u].add(v);
        adj[v].add(u);
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

    private static int connectedComponents() {
        int count = 0;

        for(int i = 0 ; i < vertices ; i++) {
            if(flag[i] == 0) {
                dfs(i);
                count++;
            }
        }

        return count;
    }


    private static void dfs(int source) {

        flag[source] = 1;

        for(int v : adj[source]) {
            if(flag[v] == 0) {
                dfs(v);
            }
        }

    }


    public static void main(String[] args) {

        ConnectedComponents cc = new ConnectedComponents(9);

        cc.addEdge(0,1);
        cc.addEdge(0,3);
        cc.addEdge(1,2);
        cc.addEdge(2,3);
        cc.addEdge(4,5);
        cc.addEdge(6,7);
        cc.addEdge(6,8);
        cc.addEdge(7,8);

        System.out.println(cc);

        int connectedComponents =  connectedComponents();
        System.out.println("\n"+ connectedComponents);

    }

}
