package ds_algo.graph;

import java.util.*;

/**
 * Author: nitinkumar
 * Created Date: 11/01/21
 * Info: Given a disconnected graph (where atleast one node is unreachable), write a program to do depth first search traversal of the graph
 ***/

public class DFSInDisconnectedGraph {
    //Graph to maintain vertex (say a) and list of connected vertex to a. Did not use adjacency list as there are some unreachable vertexes.
    static HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

    public static void main(String[] args) {
        int numOfVertex = 5; // vertex: 0, 1,2,3,4,5
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(3, 4);
        doDFSOfGraph(numOfVertex);
        /*
        int numOfVertex = 7; // vertex: 0, 1,2,3,4,5,6,7
        addEdge(1, 0);
        addEdge(1, 2);
        addEdge(2, 5);
        addEdge(3, 4);
        addEdge(4, 6);
        doDFSOfGraph(numOfVertex); // O/P: 0 1 2 5 3 4 6
        */
    }

    public static void addEdge(Integer a, Integer b) {
        if (graph.containsKey(a)) {
            LinkedList ll = graph.get(a);
            ll.add(b);
            graph.put(a, ll);
        } else {
            LinkedList ll = new LinkedList() {{
                add(b);
            }};
            graph.put(a, ll);
        }
    }

    public static void doDFSOfGraph(int numOfVertex) {
        boolean[] visited = new boolean[numOfVertex]; //keeps track of nodes that are visited previously. All set to false initially.
        //print each vertex and make it visited
        for (int i = 0; i < numOfVertex; i++) {
            if (visited[i] == false) { // ith node is not visited
                LinkedList<Integer> ithConnectedVertexes = graph.get(i);
                System.out.print(i + " ");
                visited[i] = true;

                //Utility checks if each of the vertex of ithConnectedVertexes is visited. If not then adds the vertex in a queue. In the queue, poll elements and print + mark visited.
                if (ithConnectedVertexes != null)
                    dfsUtility(ithConnectedVertexes, visited);
            }
        }
    }

    private static void dfsUtility(LinkedList<Integer> connectedVertexes, boolean[] visited) {
        Queue<Integer> queue = new java.util.LinkedList<>();
        for (int i = 0; i < connectedVertexes.size(); i++) {
            if (visited[connectedVertexes.get(i)] == false) {
                queue.add(connectedVertexes.get(i));
                while (!queue.isEmpty()) {
                    int pollInt = queue.poll();

                    System.out.print(pollInt + " ");
                    visited[pollInt] = true;
                    if (graph.containsKey(pollInt)) {
                        Iterator<Integer> itr = graph.get(pollInt).iterator();
                        while (itr.hasNext()) {
                            int vertex = itr.next();
                            if (visited[vertex] == false) {
                                queue.add(vertex);
                            }
                        }
                    }
                }
            }
        }
    }
}
/*
O/P:
0 4 1 2 3
 */