package ds_algo.string;

/**
 * Author: kunitin
 * Created: 30/08/23
 * Info: Given an integer A, convert it to a roman numeral, and return a string corresponding to its roman numeral version
 * 1 <= numberToConvert <= 3999
 *
 * Output:
 *  3999 in roman is MMMCMXCIX
 *  399 in roman is CCCXCIX
 *  479 in roman is CDLXXIX
 **/

public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        int num = 3999;
        System.out.println(" " + num + " in roman is " + integerToRoman.convertIntToRoman(num));

        int num1 = 399;
        System.out.println(" " + num1 + " in roman is " + integerToRoman.convertIntToRoman(num1));

        int num2 = 479;
        System.out.println(" " + num2 + " in roman is " + integerToRoman.convertIntToRoman(num2));
    }

    public String convertIntToRoman(int A) {
        String s = lookup(A);

        if (s != "") {
            return s;
        } else {
            int maxNumberWithEndingZeros = findMaxNumberWithEndingZeros(A);
            //System.out.println(maxNumberWithEndingZeros);
            int remainderAfterRemovingMaxNumber = A - maxNumberWithEndingZeros;
            return lookup(maxNumberWithEndingZeros) + convertIntToRoman(remainderAfterRemovingMaxNumber);
        }
    }

    public int findMaxNumberWithEndingZeros(int num) {
        int tempVal = num / 1000;
        if (tempVal > 0) {
            return tempVal * 1000;
        }
        tempVal = num / 100;
        if (tempVal > 0) {
            return tempVal * 100;
        }
        tempVal = num / 10;
        if (tempVal > 0) {
            return tempVal * 10;
        }
        return 1;
    }

    public String lookup(int num) {
        switch (num) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
            case 20:
                return "XX";
            case 30:
                return "XXX";
            case 40:
                return "XL";
            case 50:
                return "L";
            case 60:
                return "LX";
            case 70:
                return "LXX";
            case 80:
                return "LXXX";
            case 90:
                return "XC";
            case 100:
                return "C";
            case 200:
                return "CC";
            case 300:
                return "CCC";
            case 400:
                return "CD";
            case 500:
                return "D";
            case 600:
                return "DC";
            case 700:
                return "DCC";
            case 800:
                return "DCCC";
            case 900:
                return "CM";
            case 1000:
                return "M";
            case 2000:
                return "MM";
            case 3000:
                return "MMM";
        }
        return "";
    }
}
