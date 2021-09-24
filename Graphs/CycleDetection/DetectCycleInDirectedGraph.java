package Graphs.CycleDetection;

import java.util.LinkedList;
import java.util.Stack;

public class DetectCycleInDirectedGraph {

    private static int[] flag;
    private static LinkedList<Integer>[] adjList;
    private static int vertices;
    private int edges;

    public DetectCycleInDirectedGraph(int nodes) {
        vertices = nodes;
        edges = 0;
        flag = new int[nodes];
        // initially every node is unvisited
        for(int i = 0 ; i < nodes ; i++) {
            flag[i] = -1;
        }

        adjList = new LinkedList[nodes];
        for(int i = 0 ; i < nodes ; i++) {
            adjList[i] = new LinkedList<>();
        }

    }

    private void addEdge(int u , int v) {
        adjList[u].add(v);
        edges++;
    }

    private static boolean detectCycle(int source) {

        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int u = stack.peek();

            if(!visited[u]) {
                visited[u] = true;
                flag[u] = 0;

                for(int v : adjList[u]) {

                    if(flag[v] == 0) {
                        return true;
                    }
                    if(!visited[v]) {
                        stack.push(v);
                        flag[v] = 0;
                    }
                }

            }else {
                stack.pop();
                flag[u] = 1;
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(vertices).append("vertices ").append(edges).append("edges ").append("\n");
        for(int v = 0 ; v < vertices ; v++) {
            sb.append(v).append(": ");
            for(int w : adjList[v]) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {


        DetectCycleInDirectedGraph dc = new DetectCycleInDirectedGraph(5);


        dc.addEdge(0,1);
        dc.addEdge(0,2);
        dc.addEdge(1,2);
        dc.addEdge(1,3);
        dc.addEdge(3,4);
        //dc.addEdge(4,1);



        System.out.println(dc);
        System.out.println(detectCycle(0));
    }
}
