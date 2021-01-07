package ds_algo.tree;

/**
 * Author: nitinkumar
 * Created Date: 07/01/21
 * Info: Check if there is any root to leaf path which sums up to given SUM
 **/

public class PathSumProblem {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(11);
        bt.root.left = new Node(15);
        bt.root.right = new Node(10);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(3);
        bt.root.right.right = new Node(7);

        int sum = 29;//true
        int sum1 = 28;//true
        int sum2 = 15;//false
        int sum3 = 30;//true
        System.out.println(doesPathSumExist(bt.root, sum));
        System.out.println(doesPathSumExist(bt.root, sum1));
        System.out.println(doesPathSumExist(bt.root, sum2));
        System.out.println(doesPathSumExist(bt.root, sum3));

    }

    private static boolean doesPathSumExist(Node nd, int sum) {
        if (nd == null) {
            if (sum == 0)
                return true;
            else
                return false;
        }
        return doesPathSumExist(nd.left, sum - nd.data) || doesPathSumExist(nd.right, sum - nd.data);
    }
}
