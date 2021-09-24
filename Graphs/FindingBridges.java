package Graphs;

import java.util.LinkedList;

// A Bridge is an edge whose removal will increase the number of connected components
// Tarjan's Algorithm
public class FindingBridges {

    private static LinkedList<Integer>[] adj ;
    private static int vertices; // vertices
    private int edges; // Edges
    private static int[] discovery;
    private static int[] low;
    private static int[] parent;
    private static int time;
    private static int bridges = 0;

    private FindingBridges(int nodes) {
        vertices = nodes;
        edges = 0;
        time = 0;
        bridges = 0;

        adj = new LinkedList[nodes];
        for (int i = 0 ; i < nodes ; i++) {
            adj[i] = new LinkedList<>();
        }

        discovery = new int[nodes];
        low = new int[nodes];
        parent = new int[nodes];

        for (int i = 0 ; i < nodes ; i++) {
            discovery[i] = -1;
            low[i] = -1;
            parent[i] = -1;
        }
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


    private static void dfs(int u) {

        discovery[u] = low[u]  = time;
        time++;

        for(int v : adj[u]) {
            if(discovery[v] == -1) { // if v is not visited
                parent[v] = u;
                dfs(v);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > discovery[u]) {
                    bridges++;
                }
            }
            else if(v != parent[u]) { // ignore the child to parent edge
                low[u] = Math.min(low[u],discovery[v]);
            }
        }

    }

    private static int findingBridgesTarjanAlgo() {

      for (int i = 0 ; i < vertices ; i++) {
          if(discovery[i] == -1) {
              dfs(i);
          }
      }

       return bridges;
    }

    public static void main(String[] args) {

        FindingBridges findingBridges = new FindingBridges(5);


        findingBridges.addEdge(0,1);
        findingBridges.addEdge(0,2);
        findingBridges.addEdge(0,3);
        findingBridges.addEdge(1,2);
        findingBridges.addEdge(3,4);

        System.out.println(findingBridges);

        int bridges = findingBridgesTarjanAlgo();
        System.out.println(bridges);

    }

}
