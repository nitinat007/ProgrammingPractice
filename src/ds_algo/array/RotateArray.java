package ds_algo.array;

/**
 * Author: nitinkumar
 * Created Date: 29/04/20
 * Info: Rotate array of size n by d position anti-clockwise in O(n) time complexity and O(1) space complexity
 **/

//re-check Later. Incorrect
public class RotateArray {

    void leftRotate(int arr[], int d, int n) {
        int i, j, temp;
        int gcd = gcd(d, n);
        int count = 0;
        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            // System.out.println("temp=" + temp);
            j = i;

            while (j <= n) {
                arr[j] = arr[(j + d) % n];
                count++;
                if (count >= n) {
                    arr[j] = temp;
                    break;
                }
                j = (j + d) % n;
            }

        }
    }

    void rightRotate(int arr[], int d, int n) {
        int i, j, temp;
        int gcd = gcd(d, n);
        int count = 0;


        temp = arr[0];
        //   System.out.println("temp=" + temp);

        for (i = 0; i < gcd; i++) {
            j = i;
            int prev = arr[i];
            while (j < n) {
                int tmp = arr[(j + d) % n];
                arr[(j + d) % n] = prev;
                prev = tmp;
//                printArray(arr, n);
//                System.out.println();
                count++;
                if (count >= n) {
                    //      arr[j] = temp;
                    break;
                }
                if (j + d > n) {
                    //     arr[(j + d) % n] = prev;
                    break;
                }
                j = (j + d);
            }
//            System.out.println("\n--");
//            printArray(arr, n);
//            System.out.println("\n--\n");
        }


    }

    /* function to print an array */
    void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        RotateArray rotate = new RotateArray();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Original: ");
        rotate.printArray(arr, arr.length);
        rotate.leftRotate(arr, 3, arr.length);
        System.out.println("\nLeft rotation by 3 position ");
        rotate.printArray(arr, arr.length);
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("\nRight rotation by 3 position ");
        rotate.rightRotate(arr1, 3, arr1.length);
        rotate.printArray(arr1, arr1.length);

        int arr3[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\n\nOriginal: ");
        rotate.printArray(arr3, arr3.length);
        rotate.leftRotate(arr3, 3, arr3.length);
        System.out.println("\nLeft rotation by 3 position  ");
        rotate.printArray(arr3, arr3.length);
        int arr4[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nRight rotation by 3 position ");
        rotate.rightRotate(arr4, 3, arr4.length);
        rotate.printArray(arr4, arr4.length);

        int arr5[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\n\nOriginal: ");
        rotate.printArray(arr5, arr5.length);
        rotate.leftRotate(arr5, 5, arr5.length);
        System.out.println("\nLeft rotation by 5 position ");
        rotate.printArray(arr5, arr5.length);
        int arr6[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("\nRight rotation  by 5 position ");
        rotate.rightRotate(arr6, 5, arr6.length);
        rotate.printArray(arr6, arr6.length);

    }
}

