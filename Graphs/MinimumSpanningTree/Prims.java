package Graphs.MinimumSpanningTree;

public class Prims {

    static class adjacencyMatrix {

        int[][] adjMatrix;
        int vertices;
        int edges;

        public adjacencyMatrix(int nodes) {
            vertices = nodes;
            edges = 0;

            adjMatrix = new int[nodes][nodes];
        }

        public void addEdge(int u , int v , int weight) {
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight; // Undirected Graph
            edges++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(vertices).append(" vertices, ").append(edges).append(" edges ").append("\n");
            for(int v = 0 ; v < vertices ; v++) {
                sb.append(v).append(": ");
                for(int w : adjMatrix[v]) {
                    sb.append(w).append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    private static void showMST(int[] parent, int[][] adjMatrix) {
        System.out.println("Edge\t\tWeight");
        for(int i = 1 ; i < adjMatrix.length ; i++) {
            System.out.println(parent[i] + "<->" + i + "\t\t" + adjMatrix[i][parent[i]]);
        }
    }

    // method for finding the vertex v that has minimum key-value and that is not added MST yet
    private static int findMinVertex(int[] distance,boolean[] mst) {

        // Initialize min value and its index
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;

        //iterate over all vertices to find minimum key-value vertex
        for(int i = 0 ; i < distance.length ; i++) {

            int item = distance[i];

            if(item < minValue && !mst[i]) {
                minValue = item;
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void designMST(int[][] adjMatrix) {

        int n = adjMatrix.length;

        // array for selecting an edge having minimum weight in cut
        int[] distance = new int[n];
        // create setOfMST array of type boolean for representing the set of vertices included in MST
        boolean[] mst = new boolean[n];
        //  array for tracking the parent of each node
        int[] parent = new int[n];

        // set the distances to infinite except for first node
        for(int i = 1 ; i < n ; i++) {
            distance[i] = 999;
        }

        // since source node doesn't have a parent
        parent[0] = -1;

        // The vertices in the MST will be equal to the number Of Vertices
        for(int i = 0 ; i < n-1 ; i++) {

            // select the vertex having minimum key and that is not added in the MST yet from the set of vertices
            int minIndex = findMinVertex(distance,mst);

            // Add the selected minimum key vertex to the setOfMST
            mst[minIndex] = true;

            // change the distance value and the parent index of all the adjacent vertices of the selected vertex. The vertices that are not yet included in Minimum Spanning Tree are only considered.
            for(int j = 0 ; j < n ; j++) {

                // The value of the graphArray[edge][vertex] is non zero only for adjacent vertices of m. setOfMST[vertex] is false for vertices not yet included in Minimum Spanning Tree
                // when the value of the graphArray[edge][vertex] is smaller than key[vertex], we update the key
                if(adjMatrix[minIndex][j] != 0 && !mst[j] && adjMatrix[minIndex][j] < distance[j]) {

                    parent[j] = minIndex;
                    distance[j] = adjMatrix[minIndex][j];

                }
            }

        }


        //print the constructed MST
        showMST(parent,adjMatrix);

    }



    public static void main(String[] args) {

        adjacencyMatrix adjacencyMatrix = new adjacencyMatrix(6);

        adjacencyMatrix.addEdge(0,1,4);
        adjacencyMatrix.addEdge(0,2,6);
        adjacencyMatrix.addEdge(1,2,6);
        adjacencyMatrix.addEdge(1,3,3);
        adjacencyMatrix.addEdge(1,4,4);
        adjacencyMatrix.addEdge(2,3,1);
        adjacencyMatrix.addEdge(3,4,2);
        adjacencyMatrix.addEdge(3,5,3);
        adjacencyMatrix.addEdge(4,5,7);

        // print graph
        System.out.println(adjacencyMatrix);

        designMST(adjacencyMatrix.adjMatrix);

    }

}



