package ds_algo.string;

/**
 * Author: nitinkumar
 * Created Date: 06/01/21
 * Info: Find nth term in count and say sequence. Example
 * 1st term = 1 (speak out this term to get next term)
 * 2nd term = 11
 * 3rd term = 21
 * 4th term = 1211
 * 5th term = 111221
 * 6th term = 312211
 * 7th term = 13112221
 **/

public class CountAndSayProblem {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(nthTermInCountAndSay(n));
    }

    private static int nthTermInCountAndSay(int n) {
        String numToReturn = "1"; //also the 1st term

        for (int i = 1; i < n; i++) {
            int tempCount = 0; //for counting freq of each char
            char prevCharInHand = ' '; //char whose freq is being counted

            int charCount = 0; //counter of while loop
            String strTmp = "";
            while (charCount < numToReturn.length()) {
                if (numToReturn.charAt(charCount) != prevCharInHand) {
                    if (tempCount != 0)
                        strTmp = strTmp + tempCount + "" + prevCharInHand;
                    else
                        strTmp = "";
                    prevCharInHand = numToReturn.charAt(charCount);
                    tempCount = 1;
                } else {
                    tempCount++;
                }
                charCount++;
            }
            numToReturn = strTmp + tempCount + "" + prevCharInHand;
        }
        return Integer.parseInt(numToReturn);
    }
}
/*
O/P:
13112221
 */