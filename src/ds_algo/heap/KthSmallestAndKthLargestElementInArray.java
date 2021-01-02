package ds_algo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Author: nitinkumar
 * Created Date: 19/12/20
 * Info: Find Kth Largest Element in an array
 **/

public class KthSmallestAndKthLargestElementInArray {

    public static void main(String[] args) {
        int[] arr = {22, 31, 21, 51, 43, 32, 11, 44}; //11,21,22,31,32,43,44,51
        int k = 4;
        System.out.println("Kth Largest: " + findKthLargestNumber(arr, k));
        System.out.println("Kth Smallest: " + findKthSmallestNumber(arr, k));

    }

    private static int findKthLargestNumber(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //creates a minHeap
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }

        for (int j = k; j < arr.length; j++) {
            if (arr[j] > heap.peek()) {
                heap.poll();
                heap.add(arr[j]);
            }
        }
        return heap.peek();
    }

    private static int findKthSmallestNumber(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); //creates a maxHeap
        for (int i = 0; i < k; i++) {
            heap.add(arr[i]);
        }

        for (int j = k; j < arr.length; j++) {
            if (arr[j] < heap.peek()) {
                heap.poll();
                heap.add(arr[j]);
            }
        }
        return heap.peek();
    }
}
/*
O/P
32
 */