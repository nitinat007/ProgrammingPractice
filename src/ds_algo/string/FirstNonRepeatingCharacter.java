package ds_algo.string;

/**
 * Author: nitinkumar
 * Created Date: 06/01/21
 * Info: Given a String find the first character which does not repeat in the string
 * <p>
 * We can use hash map to store char and count. In second iteration check for count of each char in hashmap. If it is 1 return. For now lets use array.
 * Time complexity is O(n)
 * Space Complexity is O(1) . As constant (26) space is used.
 **/

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("abcdefabcefg"));
    }

    private static char firstNonRepeatingChar(String str) {
        int[] arr = new int[26];
        char[] strToCharArr = str.toLowerCase().toCharArray();
        for (int i = 0; i < strToCharArr.length; i++) {
            char c = strToCharArr[i];
            arr[c - 97] = arr[c - 97] + 1; //ascii value of a is 97
        }
        for (char c : strToCharArr) {
            if (arr[c - 97] == 1) {
                return c;
            }
        }
        return ' ';
    }
}
/*
O/P:
d
 */