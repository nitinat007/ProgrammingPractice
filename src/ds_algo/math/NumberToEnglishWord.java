package ds_algo.math;

/**
 * Author: nitinkumar
 * Created Date: 16/01/21
 * Info: Convert a given number to English word. Eg: 1234 is one thousand two hundred thirty four
 **/

public class NumberToEnglishWord {
    public static void main(String[] args) {
        int num1 = 1234;
        printNumberToWord(num1);
    }

    private static void printNumberToWord(int num) {
        char[] numAsChars = Integer.toString(num).toCharArray();
        // check for 0
        String[] unitDict = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teenDict = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensDict = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] tensOnwardsDict = {"", "", "hundred", "thousand", "lakh"};

        //ToDo
    }
}
