package ds_algo.math;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: Check if given number is a palindrome
 * <p>
 * Solve without converting num to string
 **/

public class CheckIfNumberIsPalindrome {
    public static void main(String[] args) {
        int num1 = 123454321;
        int num2 = 12300321;
        System.out.println(isPalindrome(num1));
        System.out.println(isPalindrome(num2));
    }

    private static boolean isPalindrome(int num) {
        int tmp = num;
        int numOfDigs = numOfDigits(num);
        int dividerDigit = 1;
        for (int i = 0; i < numOfDigs - 1; i++) {
            dividerDigit = dividerDigit * 10;
        }
        while (tmp != 0) {
            int lastDigit = tmp % 10;
            int firstDigit = tmp / dividerDigit;
            if (firstDigit != lastDigit) {
                return false;
            }
            tmp = tmp % dividerDigit;
            tmp = tmp / 10;
            dividerDigit = dividerDigit / 100;
        }
        return true;
    }

    private static int numOfDigits(int num) {
        int size = 0;
        while (num > 0) {
            size++;
            num = num / 10;
        }
        return size;
    }
}
/*
O/P:
true
true
 */
