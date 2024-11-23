package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFF {
    /*
     * 0 -> [1, 4]
     * 1 -> [0, 2, 3, 4]
     * 2 -> [1, 3]
     * 3 -> [1, 2, 4]
     * 4 -> [0, 1, 3]
     */
    private static ArrayList<ArrayList<Integer>> adjList;
    private static int V;
    private static int E;
    //
    // 0 -> 1
    private static ArrayList<Integer> path;
    private static ArrayList<Boolean> visited;

    public static void main(String[] args) {
        // Initialize graph
        // Initialize V and E = 4
        V = 5; // vertex
       

        adjList = new ArrayList<>();
 
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        // Add edges to the graph
        adjList.get(0).add(1);
        adjList.get(1).add(0);

        adjList.get(0).add(2);
        adjList.get(2).add(0);

        adjList.get(1).add(3);
        adjList.get(3).add(1);

        adjList.get(2).add(4);
        adjList.get(4).add(2);

        BFS(1);
        // adjList
        // {
        //     {1, 2}, // 0
        //     {3 },  // 1
        //     {4 },  // 2
        //     {1 }, // 3
        //     {2 }, // 4
        // }
        // visited
        // {
        //     true, true, true, true, true
        // }
        // path show the min distance from s to each vertex
        // {
        //     -1, 0, 0, 1, 2
        // }
        for (int i = 0; i < V; i++) {
            System.out.print(visited.get(i) + " ");
        }
        System.out.println(path.toString());
        printPath(1, 2);
        printPathRec(1, 2);
        
    }

    private static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        path = new ArrayList<Integer>();
        visited = new ArrayList<Boolean>();
        // Init visited with false value
        for (int i = 0; i < V; i++) {
            visited.add(false);
            path.add(-1);
        }
        q.add(s);
        visited.set(s, true);
        
        while (!q.isEmpty()) {
            int u = q.remove();
            // Each vertex v is adjacent to u
            for (int v : adjList.get(u)) {
                if (visited.get(v) == false) {
                    visited.set(v, true);
                    path.set(v, u);
                    q.add(v);
                }
            }
        }
    }

    private static void printPath(int source, int destination) {
        //  TODO : handle edge cases

        // flow
        ArrayList<Integer> p = new ArrayList<>();
        int current = destination;
        while (current != source) {
            p.add(current);
            current = path.get(current);
        }
        p.add(source);

        StringBuilder sb = new StringBuilder(p.toString());
        System.out.println(sb.reverse().toString());
    }

    private static void printPathRec(int source, int destination) {
        if (source == destination) {
            System.out.print(destination + " ");
            return;
        } else {
            printPathRec(source, path.get(destination));
            System.out.print(destination + " ");
        }

    }
    
}
