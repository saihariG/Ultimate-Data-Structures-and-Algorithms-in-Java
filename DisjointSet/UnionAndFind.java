package DisjointSet;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UnionAndFind {


    private static int find(int v,int[] parent) {

        if(parent[v] == -1) {
            return v;
        }else {
            return find(parent[v],parent);
        }

    }


    private static void union(int from , int to, int[] parent) {

        int from_parent = find(from,parent);
        int to_parent =  find(to,parent);

        parent[from_parent] = to_parent;

    }

    private static boolean isCyclic(List<Integer> pair,int[] parent) {


             int from = pair.get(0);
             int to = pair.get(1);

             int fromParent = find(from,parent);
             int toParent = find(to,parent);

             if(fromParent == toParent) {
                 return true;
             }else {
                 union(fromParent, toParent, parent);
                 return false;
             }
    }


     public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);

         int vertices = sc.nextInt();
         int edges = sc.nextInt();


         int[] parent = new int[vertices];

         // initialize all the parents to -1
         for(int i =  0 ; i < vertices ; i++) {
             parent[i] = -1;
         }

         List<List<Integer>> edgeList = new ArrayList<>();

         for(int i = 0 ; i < edges ; i++) {

              List<Integer> pair = new ArrayList<>();

              for(int j = 0 ; j < 2 ; j++) {
                  pair.add(sc.nextInt());
              }

              edgeList.add(pair);
         }

         // processing all the edges
         for(int i = 0 ; i < edgeList.size() ; i++) {
             List<Integer> pair = edgeList.get(i);

             if(isCyclic(pair,parent)) {
                 System.out.println("True");
             }else {
                 System.out.println("false");
             }
         }

     }

}
