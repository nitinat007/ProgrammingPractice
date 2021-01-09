package ds_algo.string;

/**
 * Author: nitinkumar
 * Created Date: 09/01/21
 * Info: Given two strings s1 & s2 each with backspace character (#) , Compare if both are equal.
 * str1="ab#cde#f" => acdf
 * str2="acdg#f"   => acdf
 * str3="acdgf#"   => acdg
 * str4="ab#cf"    => acf
 * str5="acb#d"    => acd
 **/

public class CompareStringsWithBackspaceCharacter {
    public static void main(String[] args) {
        String str1 = "ab#cde#f";
        String str2 = "acdg#f";
        String str3 = "acdgf#";
        String str4 = "ab#cf";
        String str5 = "acb#d";
        System.out.println(compareStrings(str1, str2));
        System.out.println(compareStrings(str2, str3));
        System.out.println(compareStrings(str3, str4));
        System.out.println(compareStrings(str3, str5));
    }

    private static boolean compareStrings(String str1, String str2) {
        int iStr1 = 0;
        int iStr2 = 0;
        String tempStr1 = "";
        String tempStr2 = "";
        while (iStr1 < str1.length() && iStr2 < str2.length()) {
            if ((iStr1 + 1 < str1.length() && str1.charAt(iStr1 + 1) == '#') || (iStr2 + 1 < str2.length() && str2.charAt(iStr2 + 1) == '#')) {
                if (str1.charAt(iStr1 + 1) == '#') {
                    iStr1 = iStr1 + 2;
                }
                if (str2.charAt(iStr2 + 1) == '#') {
                    iStr2 = iStr2 + 2;
                }
            } else {
                if (str1.charAt(iStr1) != str2.charAt(iStr2)) {
                    return false;
                }
                tempStr1 = tempStr1 + str1.charAt(iStr1);
                tempStr2 = tempStr2 + str2.charAt(iStr2);
                iStr1++;
                iStr2++;
            }

        }

        if (iStr1 != str1.length() || iStr2 != str2.length()) { //Size of Strings must be unequal
            return false;
        }
        return true;
    }
}
/*
true
false
false
false
 */