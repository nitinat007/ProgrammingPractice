package ds_algo.dp;

/**
 * Author: kunitin
 * Created: 23/09/23
 * Info: A frog is on 1st stair of total N stairs and wants to reach Nth Stair. Energy E at each stair is given as array.
 * Energy lost on jumping from ith to i+1 stair is | E[i] - E[i+1] | . Frog can jump one or two steps at a time. Find minimum total enery used by frog.
 **/

public class FrogJumpProblem {

    public static void main(String[] args) {
        //int[] E = {10,20,30,10}; // ans 20
        int[] E = {30, 10, 60, 10, 50}; // ans 40

        System.out.println(minEnergyUsed(E, E.length - 1));

        int[] dp = new int[E.length];
        System.out.println(">" + minEnergyUsed(E, E.length - 1, dp));

        dp = new int[E.length];
        minEnergyUsedDP(E, E.length - 1, dp);
        System.out.println("->" + dp[dp.length - 1]);

        dp = new int[E.length];
        System.out.println("-->" + minEnergyUsedTabulation(E, E.length, dp));

        System.out.println("--->" + minEnergyUsedTabulationOptimized(E, E.length));

    }


    //recursion
    private static int minEnergyUsed(int[] E, int n) {
        if (n <= 0) {
            return 0;
        }

        //System.out.println("** for n="+n);
        //frog reaching n when jumping from n-1 th stair
        int n1 = (n - 1 >= 0) ? minEnergyUsed(E, n - 1) + Math.abs(E[n] - E[n - 1]) : E[n];

        //frog reaching n when jumping from n-2 nd stair
        int n2 = (n - 2 >= 0) ? minEnergyUsed(E, n - 2) + Math.abs(E[n] - E[n - 2]) : E[n];

        return Math.min(n1, n2);
    }

    //transforming above recursion into DP. Uses Memoization (top-down)
    private static int minEnergyUsed(int[] E, int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        //frog reaching n when jumping from n-1 th stair
        int n1 = (n - 1 >= 0) ? minEnergyUsed(E, n - 1, dp) + Math.abs(E[n] - E[n - 1]) : E[n];

        //frog reaching n when jumping from n-2 nd stair
        int n2 = (n - 2 >= 0) ? minEnergyUsed(E, n - 2, dp) + Math.abs(E[n] - E[n - 2]) : E[n];

        return dp[n] = Math.min(n1, n2);
    }

    //DP
    private static void minEnergyUsedDP(int[] E, int n, int[] DP) {
        //System.out.println("** for n="+n);
        if (n < 0) {
            return;
        } else if (n <= 1) {
            DP[n] = Math.abs(E[n] - E[0]);
            //System.out.println("-> DP["+n+"]="+DP[n]);
            return;
        }

        //Fill DP array
        minEnergyUsedDP(E, n - 1, DP);
        if (n >= 2) {
            //System.out.println("**"+Arrays.toString(DP));
            DP[n] = Math.min(DP[n - 2] + Math.abs(E[n - 2] - E[n]), DP[n - 1] + Math.abs(E[n - 1] - E[n]));
            //System.out.println("DP["+n+"] ="+DP[n]);
        }

    }

    // DP. Uses Tabulation (bottom-up). Time Comp: O(n) , space comp: O(n)
    private static int minEnergyUsedTabulation(int[] E, int n, int[] DP) {

        DP[0] = 0;
        for (int i = 1; i < n; i++) {
            //if reaching i from i-1 th step
            int fst = DP[i - 1] + Math.abs(E[i] - E[i - 1]);
            //if reaching i from i-2 th step
            int sec = Integer.MAX_VALUE;
            if (i > 1) {
                sec = DP[i - 2] + Math.abs(E[i] - E[i - 2]);
            }
            DP[i] = Math.min(fst, sec);
        }

        return DP[n - 1];

    }

    // DP. Uses Tabulation (bottom-up). improve space complexity. Time Comp: O(n) , space comp: O(1)
    //Note: Whenever we see a pattern of index-1 & index-2 we can always optimize the space complexity
    private static int minEnergyUsedTabulationOptimized(int[] E, int n) {

        int prev1 = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            //if reaching i from i-1 th step
            int fst = prev1 + Math.abs(E[i] - E[i - 1]);
            //if reaching i from i-2 th step
            int sec = Integer.MAX_VALUE;
            if (i > 1) {
                sec = prev2 + Math.abs(E[i] - E[i - 2]);
            }
            int curr = Math.min(fst, sec);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }
}
/*
OP:
40
>40
->40
-->40
--->40
 */