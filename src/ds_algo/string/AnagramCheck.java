package ds_algo.string;

/**
 * Author: nitinkumar
 * Created Date: 10/01/21
 * Info: Check if two given strings are a valid anagram of each other. Eg: "abcdef" & "bcadfe" are valid anagrams.
 * <p>
 * Logics: Use any one
 * 1. store each char of both strings in two maps and compare map.
 * 2. use one array of size (26 or 256). increment value at ('char' - 97 ) position for each char in str1. Also decrement for chars in str2. Check if array is empty
 * 3. Sort chars in Strings and compare each char. Time Complexity = n logn . Space Complexity= O(1)
 * 4. find ASCII sum of each char in str1 as count. decrement ASCII value of each char from count. Finally check if count is 0. Space complexity= O(1). Time complexity= O(n). Best Solution.
 **/

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "bcadfh";
        System.out.println(checkAnagram(str1, str2));
    }

    private static boolean checkAnagram(String str1, String str2) {
        int count = 0;
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            count = count + str1.charAt(i);
            count = count - str2.charAt(i);
        }
        return count == 0;
    }
}
/*
O/P:
false
 */