package Graphs.GraphRepresentation;

public class AdjacencyMatrix {

    private final int V; // Vertices
    private int E; // Edges
    private static int[][] adjMatrix;

    public AdjacencyMatrix(int nodes) {
        V = nodes;
        E = 0; // initially no edges
        adjMatrix = new int[nodes][nodes];
    }

    private void addEdge(int u , int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Undirected Graph
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ").append(E).append(" edges ").append("\n");
        for(int v = 0 ; v < V ; v++) {
            sb.append(v).append(": ");
            for(int w : adjMatrix[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);

        System.out.println(g);
    }

}
