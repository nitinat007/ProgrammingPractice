package ds_algo.string;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 31/08/23
 * Info: Given two numbers represented as strings, return the multiplication of the numbers as a string.
 *
 * For some very large inputs, this does not work. Re-check later
 **/

public class MultiplyTwoNumbers {
    public static void main(String[] args) {
        String A = "6020453667958309279424408570378228292268488402";
        //String B = "0021473700594524297017810575200827941459805716642468749607585313713214621412";
        String B = "000021473700594524297017810575200827941459805716642468749607585313713214621412";
        System.out.println(new MultiplyTwoNumbers().multiply(A, B));
        //expected: 129281419508942330644788914772375911909165364374172850648846234013189757981044692486872392891670352883617068289942863624
        //found:    129281419508942330644690820643223144372446578466779697080786888688888515161006995786554354212030003083617068289942863624
    }

    public String multiply(String A, String B) {
        if (A.equals("0") || B.equals("0")) {
            return "0";
        }
        String[] intermediateState = new String[B.length()];
        Arrays.fill(intermediateState, "");
        int intStateTracker = 0;
        String valueToReturn = "";

        for (int i = B.length() - 1; i >= 0; i--) {
            int carry = 0;
            char numericPart = '0';
            for (int j = A.length() - 1; j >= 0; j--) {
                int tmpValWithCarry = Character.getNumericValue(A.charAt(j)) * Character.getNumericValue(B.charAt(i));
                int tmpValAfterAddingCarry = tmpValWithCarry + carry;
                String tmpValAfterAddingCarryInStr = String.valueOf(tmpValAfterAddingCarry);
                if (tmpValAfterAddingCarryInStr.length() > 1) {
                    carry = Character.getNumericValue(tmpValAfterAddingCarryInStr.charAt(0));
                    numericPart = tmpValAfterAddingCarryInStr.charAt(1);
                } else {
                    carry = 0;
                    numericPart = tmpValAfterAddingCarryInStr.charAt(0);
                }

                intermediateState[intStateTracker] = numericPart + intermediateState[intStateTracker];
            }
            //add carry if not 0
            if (carry != 0) {
                intermediateState[intStateTracker] = carry + intermediateState[intStateTracker];
            }
            //System.out.println("intStateTracker: "+intermediateState[intStateTracker]);
            intStateTracker++;
        }
        intStateTracker = 0;
        while (intStateTracker < intermediateState.length) {

            int tmpZeroTracker = 0;
            while (tmpZeroTracker < intStateTracker) {
                intermediateState[intStateTracker] += "0";
                tmpZeroTracker++;
            }
            //System.out.println("* intStateTracker: "+intermediateState[intStateTracker]);
            intStateTracker++;

        }
        int maxSizeOfIntStateTracker = intermediateState[intermediateState.length - 1].length();
        //System.out.println("MaxSizeOfIntStateTracker: "+maxSizeOfIntStateTracker);

        //append zeros in beginning
        intStateTracker = 0;
        while (intStateTracker < intermediateState.length) {

            int tmpZeroTracker = 0;

            int iterationsToRun = (maxSizeOfIntStateTracker - intermediateState[intStateTracker].length());
            // System.out.println("\niterationsToRun:"+iterationsToRun);
            for (int i = 0; i < iterationsToRun; i++) {
                // System.out.println("----i:"+i+ " iterationsToRun:"+iterationsToRun);
                intermediateState[intStateTracker] = "0" + intermediateState[intStateTracker];
            }
            //System.out.println("** intStateTracker: "+intermediateState[intStateTracker]);
            intStateTracker++;

        }
        int carry = 0;
        for (int i = maxSizeOfIntStateTracker - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = 0; j < intermediateState.length; j++) {
                sum += Character.getNumericValue(intermediateState[j].charAt(i));
            }
            sum = sum + carry;
            String sumToString = String.valueOf(sum);
            if (sumToString.length() > 1) {
                carry = Character.getNumericValue(sumToString.charAt(0));
                valueToReturn = sumToString.charAt(1) + valueToReturn;
            } else {
                carry = 0;
                valueToReturn = sumToString.charAt(0) + valueToReturn;
            }

        }
        //return String.valueOf(Integer.parseInt(valueToReturn)); //fails
        System.out.println(valueToReturn);
        return removeInitialZeros(valueToReturn);
    }

    public String removeInitialZeros(String str) {

        for (int i = 0; i < str.length(); i++) {
            System.out.println("**** "+str.charAt(i));
            if (str.charAt(i) == '0') {
                str = customCopyStr(str, i + 1);
                System.out.println("str nw: " + str);
            } else {
                return str;
            }
        }
        return str;
    }

    public String customCopyStr(String str, int from) {
        int strSize = str.length();
        String strReturn = "";
        for (int i = from; i < strSize; i++) {
            strReturn = strReturn + str.charAt(i);
        }

        return strReturn;
    }
}

/*

Your submission failed for the following input
A : "5131848155574784703269632922904933776792735241197982102373370"
B : "56675688419586288442134264892419611145485574406534291250836"

The expected return value:
290851027081985078955918627261751688832742312387314888842460711865148550965912482730570750031304678344564428861596637320
Your function returned the following:
290851027081985078944116232213554567457798900211352654347549446633533261310199777777755442210101100344564428861596637320
 */