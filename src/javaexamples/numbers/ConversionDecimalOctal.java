package javaexamples.numbers;

/**
 * Author: nitinkumar
 * Created Date: 15/12/20
 * Info: Convert decimal to octal. Octal to decimal
 **/

public class ConversionDecimalOctal {
    //int[] octalArray = {0, 1, 2, 3, 4, 5, 6, 7};

    public static void main(String[] args) {
        decimalToOctal(1911);
        decimalToOctal(101);
        decimalToOctal(19);
        System.out.println("*****");
        octalToDecimal(3567);
        octalToDecimal(145);
        octalToDecimal(23);
    }

    public static int decimalToOctal(int dec) {
        int octalConvertedNumber = 0;
        int multiplier = 1;
        while (dec > 0) {
            int remainder = dec % 8;
            octalConvertedNumber = octalConvertedNumber + remainder * multiplier;
            multiplier = multiplier * 10;
            dec = dec / 8;
        }
        System.out.println(octalConvertedNumber);
        return octalConvertedNumber;
    }

    public static int octalToDecimal(int oct) {
        int incrementer = 0;
        int decimal = 0;
        while (oct > 0) {
            int lastDigit = oct % 10;
            decimal = (int) (decimal + lastDigit * Math.pow(8, incrementer));
            incrementer++;
            oct = oct / 10;
        }
        System.out.println(decimal);
        return decimal;
    }

}
