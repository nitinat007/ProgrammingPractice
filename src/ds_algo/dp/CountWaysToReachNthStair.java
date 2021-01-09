package ds_algo.dp;

/**
 * Author: nitinkumar
 * Created Date: 09/01/21
 * Info: If one can take 1,2 or 3 step at a time. Count number of ways to reach Nth  stair.
 **/

public class CountWaysToReachNthStair {
    public static void main(String[] args) {
        waysToReachStair(1);
        waysToReachStair(2);
        waysToReachStair(3);
        waysToReachStair(4);
        waysToReachStair(5);
        waysToReachStair(6);
        waysToReachStair(7);
    }

    private static void waysToReachStair(int n) {
        int dpArr[] = new int[n + 1]; //stores number of ways to reach ith stair.
        dpArr[0] = 1; //1 way to reach oth stair i.e pain
        int ways = 0;
        //One can reach Xth stair either by climbing from (X-1)the step , (X-2)th step or from (X-3)rd step (when one climbs 1 , 2, 3 steps respectively).
        // Number of ways to reach Xth stair is sum of number of ways to (X-1)th stair plus sum of number of ways to reach (x-2)th stair plus sum of number of ways to reach (X-3)rd stair.
        for (int i = 1; i < dpArr.length; i++) {
            ways = ways + dpArr[i - 1];
            if (i - 2 >= 0) {
                ways = ways + dpArr[i - 2];
            }
            if (i - 3 >= 0) {
                ways = ways + dpArr[i - 3];
            }
            dpArr[i] = ways;
            ways = 0;
        }

        System.out.println(dpArr[n]);
    }
}
/*
O/P:
1
2
4
7
13
24
44
 */