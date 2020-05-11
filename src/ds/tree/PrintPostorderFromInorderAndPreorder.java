package ds.tree;

/**
 * Author: nitinkumar
 * Created Date: 11/05/20
 * Info: Print Postorder traversal of tree from given inorder and preorder traversal. Approach 1: make tree and do traversal. Approach2: Without making tree
 * Order: O(n2)
 **/

public class PrintPostorderFromInorderAndPreorder {

    static int preStart = 0;
    static int n;

    public static void main(String[] args) {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        n = in.length;
        System.out.print("Postorder traversal: ");
        printPostOrder(in, pre, 0, n);
    }

    private static void printPostOrder(int[] in, int[] pre, int inStart, int inEnd) {
        if (inStart == inEnd)
            return;
        if (preStart < n) {
            int posIn = search(in, pre[preStart++], inStart, inEnd);
            printPostOrder(in, pre, inStart, posIn);
            printPostOrder(in, pre, posIn + 1, inEnd);
            System.out.print(in[posIn] + " ");
        }
    }

    private static int search(int[] in, int toFind, int inStart, int inEnd) {
        for (int count = inStart; count < inEnd; count++) {
            if (in[count] == toFind) {
                return count;
            }
        }
        return -1;
    }
}

/*
Output
Postorder traversal: 4 5 2 6 3 1
 */
