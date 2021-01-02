package ds_algo.tree.bst;

/**
 * Author: nitinkumar
 * Created Date: 11/05/20
 * Info: Print Postorder traversal of BST from given Preorder Traversal
 * Level: 4
 **/

public class PrintPostorderFromPreorder {

    static int preIndex = 0;
    static int n;

    public static void main(String[] args) {
        int pre[] = {40, 30, 35, 80, 100}; // expected 35 30 100 80 40
        n = pre.length;
        System.out.print("Postorder Traversal: ");
        printPostorder(pre, 0, n);

    }

    private static void printPostorder(int[] pre, int leftIndex, int rightIndex) {

        if (leftIndex >= rightIndex) {
            return;
        }
        if (preIndex < n) {
            int val = pre[preIndex++];

            int indexValueGTValue = findIndexWhoseValueIsGreaterThanGivenValue(pre, val, preIndex, rightIndex);

            if (indexValueGTValue >= 0) {
                printPostorder(pre, preIndex, indexValueGTValue);
                printPostorder(pre, indexValueGTValue, rightIndex);
                System.out.print(val + " ");
            } else {
                System.out.print(val + " ");
            }

        }
    }

    private static int findIndexWhoseValueIsGreaterThanGivenValue(int[] pre, int val, int leftBoundary, int rightBoundary) {
        for (int i = leftBoundary; i < rightBoundary; i++) {
            if (pre[i] > val) {
                return i;
            }
        }
        return -1;
    }


}

/*
O/P:
Postorder Traversal: 35 30 100 80 40
 */
