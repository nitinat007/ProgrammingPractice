package ds_algo.string;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Reverse words in a sentence. Eg: "Life is beautiful" changes to "beautiful is Life".
 **/

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String str = "Life is beautiful";
        printReverseWords(str);
        printReverseWords2(str);
    }

    private static void printReverseWords(String str) {
        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }

    private static void printReverseWords2(String str) {
        int nextSpaceCharAtIndex = -1;
        //reverse each word of string first
        while (nextSpaceCharAtIndex < str.length() - 1) {
            int startIndex = nextSpaceCharAtIndex;
            nextSpaceCharAtIndex = str.indexOf(" ", startIndex + 1) > 0 ? str.indexOf(" ", startIndex + 1) : str.length();
            str = reverse(str, startIndex + 1, nextSpaceCharAtIndex - 1);
        }
        //reverse complete string once
        str = reverse(str, 0, str.length() - 1);
        System.out.println(str.toString());
    }

    private static String reverse(String str, int start, int end) {
        char[] strInCharArray = str.toCharArray();
        while (start < end) {
            char c = strInCharArray[start];
            strInCharArray[start] = strInCharArray[end];
            strInCharArray[end] = c;
            start++;
            end--;
        }
        return new String(strInCharArray);
    }
}

/*
O/P:
beautiful is Life
beautiful is Life
 */