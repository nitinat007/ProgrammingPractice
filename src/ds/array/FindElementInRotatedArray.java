package ds.array;

/**
 * Author: nitinkumar
 * Created Date: 16/12/20
 * Info: Find an element in sorted Rotated array
 **/

public class FindElementInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5,};
        int toFind = 4;
        printPositionOfElement(arr, toFind, 0, arr.length - 1);
        toFind = 7;
        printPositionOfElement(arr, toFind, 0, arr.length - 1);
        toFind = 15;
        printPositionOfElement(arr, toFind, 0, arr.length - 1);
    }

    private static void printPositionOfElement(int[] arr, int find, int start, int end) {
        //System.out.println("\nTo Find " + find + " from position " + start + " to " + end);
        if (end <= start) {
            if (find == arr[start]) {
                System.out.println("Found " + find + " at position " + start);
                return;
            } else {
                System.out.println("Element not found");
                return;
            }
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == find) {
            System.out.println(find + " found at position " + mid);
        } else if (arr[mid] <= arr[end]) {  //right side of mid is continuously increasing sub-array
            if (find > arr[mid] && find <= arr[end]) {
                printPositionOfElement(arr, find, mid + 1, end);
            } else {
                printPositionOfElement(arr, find, start, mid - 1);
            }
        } else { //left side of mid is continuously increasing
            if (find >= arr[start] && find < arr[mid]) {
                printPositionOfElement(arr, find, start, mid - 1);
            } else {
                printPositionOfElement(arr, find, mid + 1, end);
            }
        }

    }
}
/*
O/P:
4 found at position 10
Found 7 at position 1
Element not found
 */