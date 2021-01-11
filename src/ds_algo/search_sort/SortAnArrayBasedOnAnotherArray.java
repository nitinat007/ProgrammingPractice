package ds_algo.search_sort;

import java.util.*;

/**
 * Author: nitinkumar
 * Created Date: 11/01/21
 * Info: Given two arrays. Sort array1 based on the order of elements present in array2. There can be elements present in array2 but not in array1. Elements present only in array1 should appear in the end sorted.
 ***/

public class SortAnArrayBasedOnAnotherArray {
    public static void main(String[] args) {
        int[] array1 = {4, 5, 3, 2, 3, 5, 9, 4, 8};
        int[] array2 = {3, 2, 5, 4}; //O/P: 3,3,2,5,5,4,4,8,9
        sortArrayBasedOnAnotherArray(array1, array2);
        sortArrayBasedOnAnotherArrayUsingComparator(array1, array2);
    }

    //Approach1: Put each elements and its freq of array1 in a map. Traverse each element in array2 and print frequency (from map) times the element. Also remove the element traversed from map. Print remaining elements of array1 in sorted order.
    private static void sortArrayBasedOnAnotherArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> freqTracker = new TreeMap<>(); // Tree map would help to get elements which are exclusively present in array1 in a sorted order. If asked to maintain the same order of elements which are exclusively present in array1 then we can use LinkedHashMap
        for (int a : arr1) {
            freqTracker.put(a, freqTracker.getOrDefault(a, 0) + 1);
        }
        for (int b : arr2) {
            int freqOfB = freqTracker.getOrDefault(b, 0);
            for (int i = 0; i < freqOfB; i++) {
                System.out.print(b + " ");
            }
            if (freqOfB > 0) {
                freqTracker.remove(b);
            }
        }
        for (Map.Entry<Integer, Integer> entry : freqTracker.entrySet()) {
            int key = entry.getKey();
            int freq = entry.getValue();
            for (int i = 0; i < freq; i++) {
                System.out.print(key + " ");
            }
        }
    }

    //Approach2: Use Comparator Interface
    private static void sortArrayBasedOnAnotherArrayUsingComparator(int[] arr1, int[] arr2) {
        Integer[] array1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new); // convert int[] to Integer[]. you may use alternate way.
        Map<Integer, Integer> mapForArray2 = new HashMap<>(); //contains element and its position in array2
        for (int i = 0; i < arr2.length; i++) {
            mapForArray2.put(arr2[i], i);
        }
        Arrays.sort(array1, new ArrayComparator(mapForArray2));
        System.out.println();
        for (Integer i : array1) {
            System.out.print(i + " ");
        }
    }

    static class ArrayComparator implements Comparator<Integer> {
        Map<Integer, Integer> map;

        public ArrayComparator(Map map) {
            this.map = map;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            if (map.containsKey(o1) && map.containsKey(o2)) {
                return map.get(o1) - map.get(o2);
            } else if (map.containsKey(o1)) {
                return -1;
            } else if (map.containsKey(o2)) {
                return 1;
            } else {
                return o1 - o2;
            }
        }
    }

}
/*
O/P:
3 3 2 5 5 4 4 8 9
3 3 2 5 5 4 4 8 9
 */