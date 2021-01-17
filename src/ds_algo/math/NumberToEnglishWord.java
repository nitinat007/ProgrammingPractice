package ds_algo.math;

/**
 * Author: nitinkumar
 * Created Date: 16/01/21
 * Info: Convert a given number to english word. Eg: 1234 is one thousand two hundred thirty four. Program should be able to convert upto 9 digit long integer (upto 99 crore)
 **/

public class NumberToEnglishWord {
    public static void main(String[] args) {
        int num1 = 1234;
        printNumberToWord(num1);
        int num2 = 9214;
        printNumberToWord(num2);
        int num3 = 1204;
        printNumberToWord(num3);
        int num4 = 9034;
        printNumberToWord(num4);
        int num5 = 903;
        printNumberToWord(num5);
        int num6 = 900;
        printNumberToWord(num6);
        int num7 = 50;
        printNumberToWord(num7);
        int num8 = 91;
        printNumberToWord(num8);
        int num9 = 3;
        printNumberToWord(num9);
        int num10 = 0;
        printNumberToWord(num10);
        int num11 = 12345;
        printNumberToWord(num11);
        int num12 = 22305;
        printNumberToWord(num12);
        int num13 = 30305;
        printNumberToWord(num13);
        int num14 = 122305;
        printNumberToWord(num14);
        int num15 = 7122305;
        printNumberToWord(num15);
        int num16 = 17122305;
        printNumberToWord(num16);
        int num17 = 237122305;
        printNumberToWord(num17);
    }

    private static void printNumberToWord(int num) {
        char[] numAsChars = Integer.toString(num).toCharArray();
        //dictionaries
        String[] unitDict = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teenDict = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensDict = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] tensOnwardsDict = {"", "", "hundred", "thousand", "thousand", "lakh", "lakh","crore","crore"};

        String englishWord = "";
        for (int i = 0; i < numAsChars.length; i++) {
            if (numAsChars.length - i == 5 || numAsChars.length - i == 7|| numAsChars.length - i == 9) { //for digits at tenThousand's , tenLakh's  and tenCrore's place
                int digitAtIthPlace = Integer.parseInt(String.valueOf(numAsChars[i]));
                int digitAtNextPlace = Integer.parseInt(String.valueOf(numAsChars[i + 1]));
                if (digitAtIthPlace == 1) {
                    englishWord = englishWord + " " + teenDict[digitAtNextPlace] + " " + tensOnwardsDict[numAsChars.length - i - 1];
                    i++;
                } else if (digitAtIthPlace > 1) {
                    englishWord = englishWord + " " + tensDict[digitAtIthPlace] + " " + unitDict[digitAtNextPlace] + " " + tensOnwardsDict[numAsChars.length - i - 1];
                    i++;
                }
            } else if (i < numAsChars.length - 2) { //for digits at hundred's , thousand's and lakh's place
                int digitAtIthPlace = Integer.parseInt(String.valueOf(numAsChars[i]));
                if (digitAtIthPlace != 0)
                    englishWord = englishWord + " " + unitDict[digitAtIthPlace] + " " + tensOnwardsDict[numAsChars.length - i - 1];
            } else if (i == numAsChars.length - 2) { //for digits at tens place
                int digitAtPlace = Integer.parseInt(String.valueOf(numAsChars[i]));
                if (digitAtPlace > 1) {
                    englishWord = englishWord + " " + tensDict[digitAtPlace];
                } else if (digitAtPlace == 1) {
                    int digitAtUnitPlace = Integer.parseInt(String.valueOf(numAsChars[i + 1]));
                    englishWord = englishWord + " " + teenDict[digitAtUnitPlace];
                    break;
                }
            } else { //for digits at units place.
                int digitAtUnitPlace = Integer.parseInt(String.valueOf(numAsChars[i]));
                englishWord = englishWord + " " + unitDict[digitAtUnitPlace];
                if (num == 0) {
                    englishWord = "zero";
                }
            }
        }
        System.out.println(num + ": " + englishWord);
    }
}
/*
O/P:
1234:  one thousand two hundred thirty four
9214:  nine thousand two hundred fourteen
1204:  one thousand two hundred four
9034:  nine thousand thirty four
903:  nine hundred three
900:  nine hundred
50:  fifty
91:  ninety one
3:  three
0: zero
12345:  twelve thousand three hundred forty five
22305:  twenty two thousand three hundred five
30305:  thirty  thousand three hundred five
122305:  one lakh twenty two thousand three hundred five
7122305:  seventy one lakh twenty two thousand three hundred five
 */