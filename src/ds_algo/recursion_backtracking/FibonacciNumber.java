package ds_algo.recursion_backtracking;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 09/09/23
 * Info: Print fibonacci series
 * <p>
 * Multiple approaches to create fibonacci series are below
 **/

public class FibonacciNumber {
    static int[] fibNum = null;

    public static void main(String[] args) {
        int n = 10;

        printFibSeries(n);
        System.out.println();

        fibNum = new int[n];
        createFibonacci(n);
        System.out.println("-->" + Arrays.toString(fibNum));

        fibNum = new int[n];
        createFibonacciSeries(n);
        System.out.println("--->" + Arrays.toString(fibNum));

        fibNum = new int[n];
        createFibonacciSeries(n - 1, fibNum);
        System.out.println("---->" + Arrays.toString(fibNum));

        fibNum = new int[n];
        populateFibonacciSeries(n, fibNum);
        System.out.println("----->" + Arrays.toString(fibNum));
    }

    //Approach 1
    private static void printFibSeries(int n) {
        int first = 0, second = 1;
        System.out.print(first + " " + second);
        fibonacchiNumberHelper(first, second, n - 2, 0);
    }

    private static void fibonacchiNumberHelper(int first, int second, int n, int currentCount) {
        if (currentCount == n) {
            return;
        }
        System.out.print(" " + (first + second));
        fibonacchiNumberHelper(second, (first + second), n, currentCount + 1);
    }


    //Approach 2. Time complexity: O(n) for given n
    private static int createFibonacci(int n) {
        if (n == 1) {
            fibNum[1] = 1; //fibNum[0] is already 0
            return 1;
        }
        int prevNum = createFibonacci(n - 1);
        int sum = prevNum + fibNum[n - 2];
        fibNum[n - 1] = prevNum;
        return sum;
    }

    //Approach 3. Time complexity: O(2^n). Exponential, as every function calls two other functions.
    private static int createFibonacciSeries(int n) {
        if (n <= 1) {
            fibNum[n] = n;
            //System.out.println("set for "+n+"th position ="+n);
            return n;
        }
        int last = createFibonacciSeries(n - 1);
        int sLast = createFibonacciSeries(n - 2);

        //System.out.println("set for "+(n-1)+"th position. ="+(last ));
        fibNum[n - 1] = last;
        return last + sLast;
    }

    //Approach 4. DP with recursion (top-down approach). Time Complexity is O(n) Space complexity: O(n) for dp + O(n) for method stack
    private static void createFibonacciSeries(int n, int[] dp) {
        if (n < 0) {
            return;
        }
        if (n == 0 || n == 1) {
            dp[n] = n;
            return;
        }
        createFibonacciSeries(n - 1, dp); // this sets all the previous DP array values
        dp[n] = dp[n - 1] + dp[n - 2];
    }

    //Approach 5. DP with Tabulation (bottom-up approach). Time complexity: O(n) Space complexity: O(n) for dp array
    private static void populateFibonacciSeries(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }


}
/*
Output:
0 1 1 2 3 5 8 13 21 34
-->[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
--->[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
---->[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
----->[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
 */
