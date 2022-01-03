package ds_algo.bit_manipulation;

/**
 * Author: kunitin
 * Created: 03/01/22
 * Info: Contains various operations for bit manipulations.
 **/

public class AllBitOperations {
    public static void main(String[] args) {
        int n = 22; //Integer.toBinaryString(n) = 010110
        int x = 5; // xth bit from right most bit. 0,1,2,...
        System.out.println(" is " + x + " bit set? " + getXthBit(n, x));
        System.out.println(" number after setting " + x + "th bit is " + setXthBit(n, x));

        int updateToBit = 0; // 0 or 1
        System.out.println("number after updating " + x + "th bit to " + updateToBit + " is " + updateXthBit(n, x, updateToBit));

        System.out.println("number after resetting all bit from most significant bit to " + x + "th position (from right) is " + clearAllBitFromMSBToXthBit(n, x));
    }

    //get xth bit
    static boolean getXthBit(int n, int x) {
        int mask = 1 << x;
        return (n & mask) > 0;
    }

    //set xth bit
    static int setXthBit(int n, int x) {
        //no need to clear the xth bit of n
        int maskToSetXthBit = 1 << x;
        int returnValue = n | maskToSetXthBit;
        return returnValue;
    }

    //update xth bit
    static int updateXthBit(int n, int x, int toBit) {
        int maskToClearXthBit = ~(1 << x);
        int maskToSetXthBit = toBit << x;
        int returnValue = (n & maskToClearXthBit) | maskToSetXthBit; //clear the xth bit and reset to toBit
        return returnValue;
    }

    //reset all bit from MSB to xth bit (inclusive)
    static int clearAllBitFromMSBToXthBit(int n, int x) {
        int mask = (1 << x) - 1;
        return n & mask;
    }

    //rest all bit from xth bit to LSB
   // TODO

}
