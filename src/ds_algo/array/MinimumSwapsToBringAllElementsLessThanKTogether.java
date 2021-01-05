package ds_algo.array;

/**
 * Author: nitinkumar
 * Created Date: 05/01/21
 * Info: Given an array of integers and a value k. Find minimum number of swaps needed to bring all values less than equal to k together
 * arr[]={4,6,1,3,2}, k = 4   O/P: 1 (swap 6 & 2)
 * <p>
 * 'Important'
 * Logic: Count all values less than or equal to k (in variable lessThanK) and  count of all values b/w 0 and lessThanK which are more than k (in moreThanK)
 * Set a variable named 'result' to moreThanK. Run a for loop start from i=0,j=lessThanK till j is less than size of arr. if arr[i]>k then decrement moreThanK . if arr[j]>k decrement moreThanK. update result to min of result and moreThanK .
 **/

//verify result once with multiple test data.
public class MinimumSwapsToBringAllElementsLessThanKTogether {

    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 3, 2};
        int k = 4;
        System.out.println(minSwap(arr, k));
        int[] arr1 = {1, 5, 4, 7, 2, 10};
        int k1 = 5;
        //System.out.println(minSwap(arr1, k1));
    }

    private static int minSwap(int[] arr, int k) {
        int lessThanK = 0;
        int moreThanK = 0;
        //find number of values in array which are less than equal to k
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                lessThanK++;
            }
        }
        //find number of values between 0 and lessThanK which are more than k
        for (int i = 0; i < lessThanK; i++) {
            if (arr[i] > k) {
                moreThanK++;
            }
        }
        int result = moreThanK; //if all the value less than k is to be moved to the left of k.
        // Still we need to check if there is a possibility of less number of swaps if all value less than k are on the right of k. Doing so by below code.

        for (int i = 0, j = lessThanK; j < arr.length; i++, j++) {
            if (arr[i] > k) {
                moreThanK--; //as no need to move this to the right of k
            }
            if (arr[j] > k) {
                moreThanK++; //will have to move this bigger values to the left of k.
            }
            result = Math.min(result, moreThanK);
        }

        return result;
    }
}
/*
O/P:
1
 */