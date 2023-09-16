package ds_algo.recursion_backtracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 14/09/23
 * Info: Given a array of integers, find all unique sub sequence which sums up to given target number.  Sub sequences should be in ascending order.
 * <p>
 * Approach: Sort the array.
 * - In 1st approach: choose or not choose an element of array and recursively call for the subsequent (remaining) elements of the array
 * - In 2nd approach: Start filling possible values from array at each position of the sequence. (Better)
 * <p>
 * Time Complexity: O(2^n) * k : here 2^n as for all unique array we end up creating 2^n subsequence &
 * - k is for adding value in arrayList of K sized arraylist created.
 * Space complexity: O(k) for sequence of avg. length k
 **/

public class UniqueSubSequenceSumsToTarget {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 4}; //1,2,3,4,4,5
        int taget = 8;

//        int[] arr = {4,5,7,8,9,1,4,6,2,1}; //1,2,3,4,4,5
//        int taget = 8;
        System.out.println("Input: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted Input: " + Arrays.toString(arr));
        System.out.println("------");
        printUniqueSubSeq(0, arr, taget, new ArrayList<Integer>()); //there is repetition in output.
        System.out.println("------");

        //improved solution
        improvedPrintUniqueSeqSum(0, arr, taget, new ArrayList<Integer>());
        System.out.println("------");

    }

    //in this approach there are repeated sequences
    private static void printUniqueSubSeq(int start, int[] arr, int target, ArrayList<Integer> seq) {
        // System.out.println("*** start="+start+" target="+target+" , seq="+seq);
        if (target == 0) {
            System.out.println(seq);
            return;
        }
        if (start >= arr.length || start < 0 || target < 0) {
            // System.out.println(" at position: "+start+", target="+target);
            return;
        }
        // System.out.println("start:"+start);
        seq.add(arr[start]);
        printUniqueSubSeq(start + 1, arr, target - arr[start], seq);

        //System.out.println("start="+start+" -->"+Arrays.toString(arr)+" , seq="+seq);

        seq.remove(seq.size() - 1);
        // System.out.println("--> seq="+seq);
        printUniqueSubSeq(start + 1, arr, target, seq);

    }

    //no repeated sequence
    private static void improvedPrintUniqueSeqSum(int i, int[] arr, int target, ArrayList<Integer> seq) {
        // System.out.println("** i="+i+", target="+target+", seq="+seq);
        if (target == 0) {
            System.out.println(seq);
            return;
        }
        if (i >= arr.length) {
            return;
        }

        int prev = -1; // assuming -1 is not in array
        int counter = i;
        // for every position (i) check if we can or can not put the elements of array in the sequence. Eg: we can not put a number (say 2) at 1st position if
        //we already have made a recursive call with 2 added in the sequence for 1st position (just) previously.
        while (counter < arr.length) {
            if (prev != arr[counter] && (target - arr[counter] >= 0)) {
                seq.add(arr[counter]);
                improvedPrintUniqueSeqSum(counter + 1, arr, target - arr[counter], seq);
                seq.remove(seq.size() - 1);
                prev = arr[counter];
            }
            counter++;
        }

    }
}
/*
Output:
Input: [1, 3, 2, 4, 5, 4]
Sorted Input: [1, 2, 3, 4, 4, 5]
------
[1, 2, 5]
[1, 3, 4]
[1, 3, 4]
[3, 5]
[4, 4]
------
[1, 2, 5]
[1, 3, 4]
[3, 5]
[4, 4]
------
 */