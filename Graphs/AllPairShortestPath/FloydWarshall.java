package Graphs.AllPairShortestPath;

// All Pair Shortest Path Algorithm
public class FloydWarshall {

       private static int vertices;
       private static int edges;

       private static int[][] adjMatrix;

       public FloydWarshall(int nodes) {
             vertices = nodes;
             edges = 0;
             adjMatrix = new int[nodes][nodes];

             // initialize the all the diagonals to zero and remaining to infinity
             for(int i = 0 ; i < nodes ; i++) {
                    for (int j = 0 ; j < nodes ; j++) {
                           if(i == j) {
                                  adjMatrix[i][j] = 0;
                           }else {
                                  adjMatrix[i][j] = Integer.MAX_VALUE;
                           }
                    }
             }

       }

       private static void addEdge(int u , int v , int w) {
            adjMatrix[u][v] = w;
            edges++;
       }

       public String toString() {
              StringBuilder sb = new StringBuilder();
              sb.append(vertices).append(" vertices, ").append(edges).append(" edges ").append("\n");
              for(int vertex = 0 ; vertex < vertices ; vertex++) {
                     sb.append(vertex).append(":");
                     for(int w : adjMatrix[vertex]) {
                            sb.append(w).append(" ");
                     }
                     sb.append("\n");
              }
              return sb.toString();
       }

       private static void allPairShortestPath() {

              for(int k = 0 ; k < vertices ; k++) {
                     for(int i = 0 ; i < vertices ; i++) {
                            for(int j = 0 ; j < vertices ; j++) {
                                   if(adjMatrix[i][k] == Integer.MAX_VALUE || adjMatrix[k][j] == Integer.MAX_VALUE) {
                                          continue;
                                   }
                                   else if(adjMatrix[i][k] + adjMatrix[k][j] < adjMatrix[i][j]) {
                                          adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                                   }
                            }
                     }
              }

              // check for negative weight cycle
              for(int i = 0; i < vertices ; i++) {
                     if(adjMatrix[i][i] < 0) {
                            System.out.println("Negative Edge weight Cycle Exixts");
                            return;
                     }
              }


       }

       public static void main(String[] args) {

              FloydWarshall floydWarshall = new FloydWarshall(4);

              addEdge(0,1,9);
              addEdge(0,2,-4);
              addEdge(1,0,6);
              addEdge(1,3,2);
              addEdge(2,1,5);
              addEdge(3,2,1);

              allPairShortestPath();
              System.out.println(floydWarshall);
       }


}
