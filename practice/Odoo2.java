// For this challenge you will have to determine the shortest path from one node to an end node.

/*
have the function ShortestPath(strArr) take strArr which will be an array of strings which models a non-looping Graph. 
The structure of the array will be as follows: The first element in the array will be the number of nodes N (points)
in the array as a string.
The next N elements will be the nodes which can be anything (A, B, C .. Brick Street, Main Street .. etc.).
Then after the Nth element, the rest of the elements in the array will be the connections between all of the nodes. 
They will look like this: (A-B, B-C .. Brick Street-Main Street .. etc.). Although, there may exist no connections at all.

An example of strArr may be: ["4","A","B","C","D","A-B","B-D","B-C","C-D"].
Your program should return the shortest path from the first Node to the last Node in the array separated by dashes.
So in the example above the output should be A-B-D.
Here is another example with strArr being ["7","A","B","C","D","E","F","G","A-B","A-E","B-C","C-D","D-F","E-D","F-G"].
The output for this array should be A-E-D-F-G. There will only ever be one shortest path for the array.
If no path between the first and last node exists, return -1. The array will at minimum have two nodes.
Also, the connection A-B for example, means that A can get to B and B can get to A.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Odoo2 {

    public static void main(String[] args) {
        String[] testcase1 = { "4", "A", "B", "C", "D", "A-B", "B-D", "B-C", "C-D" };
        // Test cases
        System.out.println(shortestPath(testcase1)); // Output: A-B-D
        System.out.println(shortestPath(new String[]{"7", "A", "B", "C", "D", "E", "F", "G", "A-B", "A-E", "B-C", "C-D", "D-F", "E-D", "F-G"})); // Output: A-E-D-F-G
        System.out.println(shortestPath(new String[]{"4", "A", "B", "C", "D"})); // Output: -1
        System.out.println(shortestPath(new String[]{"1", "A"})); // Output: A
    }

    public static String shortestPath(String[] strArr) {
        // Step 1: Parse the input
        int N = Integer.parseInt(strArr[0]); // Number of nodes
        String[] nodes = Arrays.copyOfRange(strArr, 1, N + 1); // Extract nodes
        String[] connections = Arrays.copyOfRange(strArr, N + 1, strArr.length); // Extract edges

        // Build the adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        for (String node : nodes) {
            graph.put(node, new ArrayList<>());
        }
        for (String connection : connections) {
            String[] edge = connection.split("-");
            String u = edge[0];
            String v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: BFS to find the shortest path
        String start = nodes[0];
        String end = nodes[N - 1];

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(Arrays.asList(start));
        // A
        visited.add(start);

        while (!queue.isEmpty()) {
            // { "A" }
            List<String> path = queue.poll();
            // A
            String current = path.get(path.size() - 1);

            // If the end node is found, return the path
            if (current.equals(end)) {
                return String.join("-", path);
            }

            // Explore neighbors
            // "A-B", "B-D", "B-C", "C-D"
            /* Graph
            * "A" : { "B" }
            * "B" : { "A", "D" }
            * "C" : { "D" }
            * "D" : { "B", "C" }
            */

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }

        // If no path is found, return -1
        return "-1";
    }

}
