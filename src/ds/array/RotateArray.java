package ds.array;

/**
 * Author: nitinkumar
 * Created Date: 29/04/20
 * Info: Rotale array of size n by d position anti-clockwise
 **/

public class RotateArray {

    void leftRotate(int arr[], int d, int n) {
        int i, j, temp;
        int gcd = gcd(d, n);
        int count = 0;
        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            //  System.out.println("temp=" + temp);
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
        int arr[] = {1, 2, 3, 4, 5, 6, 7,8,9};
        rotate.leftRotate(arr, 5, 9);
        rotate.printArray(arr, 9);
    }
}

