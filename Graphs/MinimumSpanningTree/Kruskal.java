package Graphs.MinimumSpanningTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class edgePair implements Comparable<edgePair> {

    int from;
    int to;
    int weight;

    public edgePair(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    public int compareTo(edgePair ep) {

        if(weight == ep.weight) {
            return 0;
        }
        else if(weight > ep.weight) {
            return 1;
        }
        else {
            return -1;
        }

    }

    public String toString() {
        return this.from + " " + this.to + " " + this.weight;
    }
}


public class Kruskal {

    private static int[] parent;
    private static int[] rank;

    public Kruskal(int vertices) {

        parent = new int[vertices];
        // initialize all parents to -1;
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        // initialize the rank's of all vertices to 0
        rank = new int[vertices];
    }

    private static int find(int v) {
        if (parent[v] == -1) {
            return v;
        } else {
            int result = find(parent[v]);
            parent[v] = result;
            return result;
        }
    }

    private static void union(int from_parent, int to_parent) {

        int from_rank = rank[from_parent];
        int to_rank = rank[to_parent];

        if (from_rank == to_rank) {
            parent[from_parent] = to_parent;
            rank[to_parent]++;
        } else if (from_rank < to_rank) {
            parent[from_parent] = to_parent;
        } else {
            parent[to_parent] = from_parent;
        }

    }




    private static void kruskalAlgo(List<edgePair> edgeList, int edges) {

        Collections.sort(edgeList);

        int mst_edges = 0;
        int mstWeight = 0;

        for(int processedEdges = 0 ; processedEdges < edges ; processedEdges++) {
                edgePair pair = edgeList.get(processedEdges);

                int from = pair.from;
                int to = pair.to;
                int weight = pair.weight;

                int fromParent = find(from);
                int toParent = find(to);

                if(fromParent != toParent) {
                    union(fromParent,toParent);
                    mst_edges++;
                    mstWeight = mstWeight + weight;
                }

        }


        System.out.println("mstEdges " + mst_edges);
        System.out.println("mst Weight " + mstWeight);



    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        Kruskal kruskal = new Kruskal(vertices);

        List<edgePair> edgeList = new ArrayList<>();

        for (int i = 0; i < edges; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edgeList.add(new edgePair(from, to, weight));

        }


        kruskalAlgo(edgeList, edges);

    }
}


// Time : O(E log E + E log V)

// vertices = 6
// edges = 10
// edgeList
// 0 1 1
// 0 2 2
// 1 2 3
// 1 3 1
// 1 4 3
// 2 3 2
// 2 4 1
// 3 4 2
// 3 5 4
// 4 5 3
