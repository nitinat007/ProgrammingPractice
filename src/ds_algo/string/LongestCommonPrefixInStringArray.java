package ds_algo.string;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: Find longest Prefix string among all the strings in string array.
 * <p>
 * We will sort the array and compare first and last element in array and find longest prefix string
 **/

public class LongestCommonPrefixInStringArray {
    public static void main(String[] args) {
        String[] strings = {"nitin", "nigam", "nilam", "niti"};
        System.out.println(longestPrefix(strings));
    }

    private static String longestPrefix(String[] strings) {
        String commonPrefix = "";
        if (strings.length == 0) {
            return commonPrefix;
        }
        if (strings.length == 1) {
            return strings[0];
        }
        Arrays.sort(strings);
        String first = strings[0];
        String last = strings[strings.length - 1];
        int compareTillValue = first.length() < last.length() ? first.length() : last.length();

        for (int i = 0; i < compareTillValue; i++) {
            if (first.charAt(i) == last.charAt(i)) {
                commonPrefix = commonPrefix + first.charAt(i);
            } else {
                return commonPrefix;
            }
        }
        return commonPrefix;
    }
}
/*
O/P:
ni
 */