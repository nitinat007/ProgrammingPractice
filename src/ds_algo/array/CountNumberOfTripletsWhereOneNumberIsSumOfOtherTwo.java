package ds_algo.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: nitinkumar
 * Created Date: 02/01/21
 * Info: Count Triplets such that one of the numbers can be written as sum of the other two
 **/

public class CountNumberOfTripletsWhereOneNumberIsSumOfOtherTwo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //System.out.println(countTriplet(arr)); //works
        // System.out.println(countTripletRecursively(arr)); //ReCheck. Is not giving correct O/P
        System.out.println(countOfTriplet(arr)); //works
    }

    //using List . Space Complexity O(n), Time Complexity O(n^2)
    public static int countTriplet(int[] arr) {
        //  ArrayList<Integer> lst = new ArrayList<>();
        // Collections.addAll(lst, new int[][]{arr});//does not work
        List<Integer> lst = Arrays.stream(arr).boxed().collect(Collectors.toList()); //works
        // List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5); //works
        int count = 0;
        int pos = lst.size() - 1;
        while (pos > 1) {
            int maxElementOfTriplet = (int) lst.get(pos--);
            for (int i = 0; i <= pos; i++) {
                if (lst.contains(maxElementOfTriplet - (int) lst.get(i)) && lst.indexOf(maxElementOfTriplet - (int) lst.get(i)) > i) {
                    count++;
                    //System.out.println(lst.get(i) + " " + (maxElementOfTriplet - (int) lst.get(i)) + " " + maxElementOfTriplet);
                }
            }
        }
        return count;
    }

    //Time Complexity O(n^2) , Space Complexity: O(1)
    public static int countOfTriplet(int[] arr) {
        Arrays.sort(arr);   //nlog(n)
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int rightMostElement = arr[i];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (arr[left] + arr[right] == rightMostElement) {
                    count++;
                    //System.out.println(arr[left] + " " + arr[right] + " " + rightMostElement);
                    left++;
                } else if (arr[left] + arr[right] > rightMostElement) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }

    public static int countTripletRecursively(int[] arr) {
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean bool = doesTripletExist(arr, arr.length, arr[i], 0);
            if (bool == true) {
                count++;
            }
        }
        return count;
    }

    public static boolean doesTripletExist(int[] arr, int n, int sum, int countOfElementChosen) { //n is num of elements in arr

        if (countOfElementChosen == 3 && sum == 0) {
            return true;
        }
        if (countOfElementChosen == 3 || sum < 0 || n == 0) {
            return false;
        }

        boolean includedRightmost = doesTripletExist(arr, n - 1, sum - arr[n - 1], countOfElementChosen + 1);  //chosen the last element in arr
        boolean excludedRightmost = doesTripletExist(arr, n - 1, sum, countOfElementChosen); //discard the last element in arr
        return includedRightmost || excludedRightmost;
    }

}
/*
O/P
4
 */