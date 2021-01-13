package ds_algo.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: nitinkumar
 * Created Date: 13/01/21
 * Info: Given an array and a number K. Verify if an array can be divided into one or more pairs where sum of each pair is divisible by K.
 *
 * Approach: step by step below. arr given and k=7
 * arr =     {3, 5, 1, -8, 2, 4, 11, 3, 7, 14}
 *  return false if size of arr is odd
 * rem =     {3, 5, 1, -1, 2, 4, 4, 3, 0, 0}     // k-arr[i]
 * compRem = {4, 2, 6, 1, 5, 3, 3, 4, 0, 0}      //(k-rem[i])%k
 * put compRem values and its frequency in a hashMap. So, we obtain hashmap entry: 4->2 , 2->1 , 6->1 , 1->1 , 5->1 , 3->2 , 0->2
 * Again traverse hashmap and check if frequency of element (e) and freq of {(k - e) % k} are same. if not then return false. Eg freq of 4 and 3 is 2 each.
 **/

public class CheckIfArrayCanBeDividedIntoPairsSuchThatEachPairSumsUptoK {
    public static void main(String[] args) {
        int k = 7;
        int[] arr = {3, 5, 1, -8, 2, 4, 11, 3, 7, 14}; // pairs would be {3,4},{5,2},{1,-8},{11,3},{7,14}
        System.out.println(verifyPairsExist(arr, k));
    }

    private static boolean verifyPairsExist(int[] arr, int k) {
        if (arr.length % 2 == 1) {
            return false;
        }
        HashMap<Integer, Integer> numberAndItsFreq = new HashMap<>();
        for (int a : arr) {
            int rem = a % k;
            int compRem = (k - rem) % k;
            numberAndItsFreq.put(compRem, numberAndItsFreq.getOrDefault(compRem, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : numberAndItsFreq.entrySet()) {
            int e = entry.getKey();
            int freq = entry.getValue();
            int comFreq = numberAndItsFreq.get((k - e) % k);
            // System.out.println("key:" + key + " with freq:" + freq + " k-key:" + (k - key) + " with freq:" + comFreq);
            if (freq != comFreq) {
                return false;
            }
        }
        return true;
    }
}
/*
O/P:
true
 */