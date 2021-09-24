package DisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnionByRankAndFindByPathCompression {

    private static int findByCompression(int v, int[] parent) {
        // If v is the parent of itself
        if (parent[v] == -1) {
            // Then v is the representative
            return v;
        } else {
            // Recursively find the representative.
            int result = findByCompression(parent[v], parent);

            // We cache the result by moving v’s node directly under the representative of this set
            parent[v] = result;

            // And then we return the result
            return result;
        }
    }

    private static void unionByRank(int from_parent, int to_parent, int[] parent, int[] rank) {

        // Get the rank of from 's parent
        int from_rank = rank[from_parent];

        // Get the rank of to’s parent
        int to_rank = rank[from_parent];

        // If from’s rank is less than to’s rank
        if (from_rank < to_rank) {
            // Then move from under to
            parent[from_parent] = to_parent;
        }
        // Else if to’s rank is less than from’s rank
        else if (to_rank < from_rank) {
            // Then move to under from
            parent[to_parent] = from_parent;
        }
        // Else if their ranks are the same
        else {

            // Then move from under to (does not matter which one goes where)
            parent[from_parent] = to_parent;

            // And increment the result tree’s
            // rank by 1
            rank[to_parent]++;

        }

    }

    private static boolean isCyclic(List<Integer> pair, int[] parent, int[] rank) {


        int from = pair.get(0);
        int to = pair.get(1);

        int fromParent = findByCompression(from, parent);
        int toParent = findByCompression(to, parent);

        if (fromParent == toParent) {
            return true;
        } else {
            unionByRank(fromParent, toParent, parent, rank);
            return false;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();


        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        // initialize all the parents to -1
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        List<List<Integer>> edgeList = new ArrayList<>();

        for (int i = 0; i < edges; i++) {

            List<Integer> pair = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                pair.add(sc.nextInt());
            }

            edgeList.add(pair);
        }

        // processing all the edges
        for (int i = 0; i < edgeList.size(); i++) {
            List<Integer> pair = edgeList.get(i);

            if (isCyclic(pair, parent, rank)) {
                System.out.println("True");
            } else {
                System.out.println("false");
            }
        }

    }

}






