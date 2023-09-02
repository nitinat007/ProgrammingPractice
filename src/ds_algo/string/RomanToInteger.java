package ds_algo.string;

/**
 * Author: kunitin
 * Created: 30/08/23
 * Info: Given a string A representing a roman numeral, convert A into integer. Range from 1 to 3999
 *
 * O/P:
 *  Roman MMMCMXCIX in decimal is 3999
 *  Roman CCCXCIX in decimal is 399
 *  Roman CDLXXIX in decimal is 479
 **/

public class RomanToInteger {

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        String num = "MMMCMXCIX";
        System.out.println(" Roman " + num + " in decimal is " + obj.romanToInt(num));

        String num1 = "CCCXCIX";
        System.out.println(" Roman " + num1 + " in decimal is " + obj.romanToInt(num1));

        String num2 = "CDLXXIX";
        System.out.println(" Roman " + num2 + " in decimal is " + obj.romanToInt(num2));
    }

    public int romanToInt(String A) {
        int result = 0;
        for (int i = 0; i < A.length(); i++) {
            int s1 = getValueOfRoman(A.charAt(i));
            if (i + 1 < A.length()) {
                int s2 = getValueOfRoman(A.charAt(i + 1));
                if (s2 <= s1) {
                    result += s1;
                } else {
                    result += s2 - s1;
                    i++;
                }
            } else {
                result = result + s1;
            }

        }
        return result;
    }

    public int getValueOfRoman(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }
}
