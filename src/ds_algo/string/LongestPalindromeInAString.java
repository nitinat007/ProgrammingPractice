package ds_algo.string;

/**
 * Author: kunitin
 * Created: 04/09/23
 * Info: Given a string A of size N, find and return the longest palindromic substring in A. Incase of conflict, return the substring which occurs first ( with the least starting index).
 *
 * Below is bruteforce O(n^3) solution.
 * Solve it using DP in O(n^2)
 **/

public class LongestPalindromeInAString {
    public static void main(String[] args) {
        String str = "nitina";
        String str1 = "anitin";
        String str2 = "nitin";
        String str3 = "abcd";
        LongestPalindromeInAString obj = new LongestPalindromeInAString();

        System.out.println("In " + str + " : " + obj.longestPalindrome(str));
        System.out.println("In " + str1 + " : " + obj.longestPalindrome(str1));
        System.out.println("In " + str2 + " : " + obj.longestPalindrome(str2));
        System.out.println("In " + str3 + " : " + obj.longestPalindrome(str3));
    }

    public String longestPalindrome(String A) {
        for (int arrSize = A.length() - 1; arrSize >= 0; arrSize--) {
            for (int j = 0; j < A.length() - arrSize; j++) {
                boolean isStrPalindrome = isPalindrome(A.substring(j, j + arrSize + 1));
                if (isStrPalindrome == true) {
                    return A.substring(j, j + arrSize + 1);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String str) {

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

/*
Output:
In nitina : nitin
In anitin : nitin
In nitin : nitin
In abcd : a
 */