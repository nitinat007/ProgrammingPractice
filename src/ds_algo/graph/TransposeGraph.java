package ds_algo.graph;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Author: nitinkumar
 * Created Date: 02/01/21
 * Info: Transpose a graph using Adjacency List and Adjacency Matrix
 **/

public class TransposeGraph {

    public static void main(String[] args) {

        System.out.println("**** Adjacency List *****");
        int[][] edges = {{0, 1}, {0, 2}, {3, 2}, {3, 4}, {4, 5}, {6, 5}, {6, 0}};
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int numberOfNodes = 7;
        for (int i = 0; i < numberOfNodes; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            addEdge(graph, edges[i][0], edges[i][1]);
        }
        System.out.println("Printing graph before transpose: ");
        printAdjacencyListGraph(graph);

        graph = transposeUsingAdjacencyList(graph);

        System.out.println("Printing graph after transpose: ");
        printAdjacencyListGraph(graph);
        System.out.println("********");

        System.out.println("**** Adjacency Matrix *****");
        int[][] graph1 = {
                {0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0}};
        System.out.println("Print graph before transpose: ");
        printAdjacencyMatrixGraph(graph1);
        doTranspose(graph1);
        System.out.println("Print graph after transpose: ");
        printAdjacencyMatrixGraph(graph1);

        System.out.println("********");

    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) { //u -> v
        graph.get(u).add(v);
    }

    public static ArrayList<ArrayList<Integer>> transposeUsingAdjacencyList(ArrayList<ArrayList<Integer>> graph) {
        ArrayList<ArrayList<Integer>> transposeGraph = new ArrayList<>();

        int numberOfNodes = 7;
        for (int i = 0; i < numberOfNodes; i++) {
            transposeGraph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < graph.size(); i++) {
            Iterator<Integer> iterator = graph.get(i).iterator();
            while (iterator.hasNext()) {
                addEdge(transposeGraph, iterator.next(), i);
            }
        }
        return transposeGraph;
    }

    public static void printAdjacencyListGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            Iterator iterator = graph.get(i).iterator();
            System.out.print(i + " -> ");
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    }

    public static void printAdjacencyMatrixGraph(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void doTranspose(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = i; j < graph[0].length; j++) {
                //   System.out.println("exchanged graph[" + i + "][" + j + "] & graph[" + j + "][" + i + "]");
                int tmp = graph[i][j];
                graph[i][j] = graph[j][i];
                graph[j][i] = tmp;
            }
        }
    }
}
/*
O/P:
**** Adjacency List *****
Printing graph before transpose:
0 -> 1 2
1 ->
2 ->
3 -> 2 4
4 -> 5
5 ->
6 -> 5 0
Printing graph after transpose:
0 -> 6
1 -> 0
2 -> 0 3
3 ->
4 -> 3
5 -> 4 6
6 ->
********
**** Adjacency Matrix *****
Print graph before transpose:
0 1 1 0 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 1 0 1 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 0 0 0 0 1 0
Print graph after transpose:
0 0 0 0 0 0 1
1 0 0 0 0 0 0
1 0 0 1 0 0 0
0 0 0 0 0 0 0
0 0 0 1 0 0 0
0 0 0 0 1 0 1
0 0 0 0 0 0 0
********

 */