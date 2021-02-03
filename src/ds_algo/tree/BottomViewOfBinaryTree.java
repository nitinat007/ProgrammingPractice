package ds_algo.tree;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Author: nitinkumar
 * Created Date: 03/02/21
 * Info: Print the bottom view of a binary tree. Imagine a beam of light from bottom towards top, print the nodes that are visible.
 * Approach: While traversing tree, for each node we maintain the horizontal distance (Eg: any node to the left of a node is at currentHorizontalDistance -1) and level of each node in a map. This map contains key as horizontal
 * distance from root and value as pair of node data and vertical distance(i.e level). Keep updating the map value for key if the new node is at higher level.
 **/

public class BottomViewOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = new Node(10);
        bTree.root.left = new Node(5);
        bTree.root.right = new Node(20);
        bTree.root.left.left = new Node(3);
        bTree.root.left.right = new Node(7);
        bTree.root.left.right.left = new Node(6);
        bTree.root.right.right = new Node(22);
        bTree.root.right.right.left = new Node(15);
        bTree.root.right.right.right = new Node(29);

        /*
                       10
                     /   \
                    5     20
                   /  \     \
                 3     7     22
                     /      /  \
                    6     15    29

                  O/P: 3,6,7,15,22,29
         */
        printBottomView(bTree.root);
    }

    private static void printBottomView(Node node) {
        TreeMap<Integer, Pair> map = new TreeMap<Integer, Pair>(); //stores horizontalDistance from root as key and pair of nodeData and nodeLevel as value. Also maintains order of key in ascending order
        calculateBottomView(node, 0, 0, map);

        for (Integer i : map.keySet()) {
            System.out.print(map.get(i).nodeData + " ");
        }
    }

    private static void calculateBottomView(Node node, int hDistance, int level, TreeMap<Integer, Pair> map) {
        if (node == null) {
            return;
        }
        Pair pair = map.getOrDefault(hDistance, null);
        if (pair == null) {
            map.put(hDistance, new Pair(node.data, level));
        } else {
            if (level > map.get(hDistance).level) {
                map.put(hDistance, new Pair(node.data, level));
            }
        }
        calculateBottomView(node.left, hDistance - 1, level + 1, map);
        calculateBottomView(node.right, hDistance + 1, level + 1, map);
    }

    private static class Pair {
        int nodeData;
        int level;

        public Pair(int nodeData, int level) {
            this.nodeData = nodeData;
            this.level = level;
        }
    }
}
/*
O/P:
3 6 7 15 22 29
 */