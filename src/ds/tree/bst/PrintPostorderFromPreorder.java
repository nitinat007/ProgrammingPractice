package ds.tree.bst;

/**
 * Author: nitinkumar
 * Created Date: 11/05/20
 * Info: Print Postorder traversal of BST from given Preorder Traversal
 **/

public class PrintPostorderFromPreorder {

    static int preIndex = 0;
    static int n;

    public static void main(String[] args) {
        int pre[] = {40, 30, 35, 80, 100};
        n = pre.length;
        System.out.print("Postorder Traversal: ");
        printPostorder(pre, 0, n);

    }

    private static void printPostorder(int[] pre, int leftIndex, int rightIndex) {
        if (preIndex < n) {
            int val = pre[preIndex];
            System.out.println("***\n val=" + val);
            int indexValueGTValue = findIndexWhoseValueIsGreaterThanGivenValue(pre, val, preIndex, rightIndex);
            preIndex++;
            System.out.println("indexValueGTValue: " + indexValueGTValue);

            if (indexValueGTValue >= 0) {
                System.out.println("method called for " + leftIndex + " to " + indexValueGTValue);
                printPostorder(pre, leftIndex, indexValueGTValue);
                System.out.println("method called for " + indexValueGTValue + " to " + rightIndex);
                printPostorder(pre, indexValueGTValue, rightIndex);
            }
            System.out.println("Printing Value");
            System.out.println(val + "<-- ");
            // preIndex++;
        }
    }

    private static int findIndexWhoseValueIsGreaterThanGivenValue(int[] pre, int val, int leftBoundary, int rightBoundary) {
        System.out.println("Finding index for which value is greater than " + val + " . Range " + leftBoundary + " to " + rightBoundary);
        for (int i = leftBoundary; i < rightBoundary; i++) {
            if (pre[i] > val) {
                return i;
            }
        }
        return -1;
    }


}

//35 30 100 80 40
