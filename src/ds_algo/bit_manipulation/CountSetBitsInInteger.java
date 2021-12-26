package ds_algo.bit_manipulation;

/**
 * Author: kunitin
 * Created: 26/12/21
 * Info: Count number of set bit in an integer
 * Approach: Keep monitoring the last bit. If last bit is 1 increase the counter. Keep shifting the number to right by 1 bit.
 **/

public class CountSetBitsInInteger {

    public static void main(String[] args) {
        int n = 21;
        System.out.println(countSetBits(n));
    }

    private static int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
