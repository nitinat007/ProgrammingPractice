package ds_algo.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: nitinkumar
 * Created Date: 12/01/21
 * Info: Find first repeating number in an array
 **/

public class FirstRepeatingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 4, 6};
        firstRepeatingNumber(arr);
    }

    private static void firstRepeatingNumber(int[] arr) {
        int min = -1;
        Set<Integer> set = new HashSet<>();
        for (int a : arr) {
            if (set.contains(a)) {
                min = a;
                break;
            }
            set.add(a);
        }

        if (min == -1) {
            System.out.println("Not found");
        } else {
            System.out.println(min);
        }

    }
}
/*
O/P:
4
 */
