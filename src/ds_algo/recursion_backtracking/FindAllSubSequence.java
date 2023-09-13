package ds_algo.recursion_backtracking;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 11/09/23
 * Info: Find all the sub sequences of an integer array
 * <p>
 * Hint: User recursion. Choose either to choose or not choose an element
 * <p>
 * Time complexity: O(2^n * n) . Every element can be choosen or not choosen (hence 2^n) . And for every element (choosen & not choosen), you traverse
 * n element.
 * Space complexity: O(n) . Maximum depth to store n element
 **/

public class FindAllSubSequence {

    public static void main(String[] args) {
        int[] intArr = new int[]{3, 2, 5, 7, 1, 4};
        printAllSubSequences(intArr);
    }

    private static void printAllSubSequences(int[] arr) {
        printSubSeqHelper(0, arr, new int[arr.length]);
    }

    private static void printSubSeqHelper(int current, int[] arr, int[] seq) {

        if (current >= arr.length) {
            //print array
            System.out.println(Arrays.toString(seq));
            return;
        }


        //choose value at current position while creating sub-sequence
        seq[current] = arr[current];
        printSubSeqHelper(current + 1, arr, seq);

        //Reset seq.  when not choosing current value of array for creating sub-sequence
        seq[current] = 0;
        printSubSeqHelper(current + 1, arr, seq);

         /* Or: If not choosing current element first
        printSubSeqHelper(current + 1, arr, seq);
        seq[current] = arr[current];
        printSubSeqHelper(current + 1, arr, seq);
        seq[current] = 0;
         */
    }

}
/*
Output:
[3, 2, 5, 7, 1, 4]
[3, 2, 5, 7, 1, 0]
[3, 2, 5, 7, 0, 4]
[3, 2, 5, 7, 0, 0]
[3, 2, 5, 0, 1, 4]
[3, 2, 5, 0, 1, 0]
[3, 2, 5, 0, 0, 4]
[3, 2, 5, 0, 0, 0]
[3, 2, 0, 7, 1, 4]
[3, 2, 0, 7, 1, 0]
[3, 2, 0, 7, 0, 4]
[3, 2, 0, 7, 0, 0]
[3, 2, 0, 0, 1, 4]
[3, 2, 0, 0, 1, 0]
[3, 2, 0, 0, 0, 4]
[3, 2, 0, 0, 0, 0]
[3, 0, 5, 7, 1, 4]
[3, 0, 5, 7, 1, 0]
[3, 0, 5, 7, 0, 4]
[3, 0, 5, 7, 0, 0]
[3, 0, 5, 0, 1, 4]
[3, 0, 5, 0, 1, 0]
[3, 0, 5, 0, 0, 4]
[3, 0, 5, 0, 0, 0]
[3, 0, 0, 7, 1, 4]
[3, 0, 0, 7, 1, 0]
[3, 0, 0, 7, 0, 4]
[3, 0, 0, 7, 0, 0]
[3, 0, 0, 0, 1, 4]
[3, 0, 0, 0, 1, 0]
[3, 0, 0, 0, 0, 4]
[3, 0, 0, 0, 0, 0]
[0, 2, 5, 7, 1, 4]
[0, 2, 5, 7, 1, 0]
[0, 2, 5, 7, 0, 4]
[0, 2, 5, 7, 0, 0]
[0, 2, 5, 0, 1, 4]
[0, 2, 5, 0, 1, 0]
[0, 2, 5, 0, 0, 4]
[0, 2, 5, 0, 0, 0]
[0, 2, 0, 7, 1, 4]
[0, 2, 0, 7, 1, 0]
[0, 2, 0, 7, 0, 4]
[0, 2, 0, 7, 0, 0]
[0, 2, 0, 0, 1, 4]
[0, 2, 0, 0, 1, 0]
[0, 2, 0, 0, 0, 4]
[0, 2, 0, 0, 0, 0]
[0, 0, 5, 7, 1, 4]
[0, 0, 5, 7, 1, 0]
[0, 0, 5, 7, 0, 4]
[0, 0, 5, 7, 0, 0]
[0, 0, 5, 0, 1, 4]
[0, 0, 5, 0, 1, 0]
[0, 0, 5, 0, 0, 4]
[0, 0, 5, 0, 0, 0]
[0, 0, 0, 7, 1, 4]
[0, 0, 0, 7, 1, 0]
[0, 0, 0, 7, 0, 4]
[0, 0, 0, 7, 0, 0]
[0, 0, 0, 0, 1, 4]
[0, 0, 0, 0, 1, 0]
[0, 0, 0, 0, 0, 4]
[0, 0, 0, 0, 0, 0]

 */