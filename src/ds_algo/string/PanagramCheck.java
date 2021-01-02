package ds_algo.string;

import java.util.ArrayList;

/**
 * Author: nitinkumar
 * Created Date: 26/12/20
 * Info: Check if a sentence is a Panagram. A panagram is a sentence which has every english alphabet. Eg: The quick brown fox jumps over the lazy dog
 * Try to use streams
 **/

public class PanagramCheck {
    public static void main(String[] args) {
        String validPanagram = "The quick brown fox jumps over the lazy dog";
        String inValidPanagram = "The quick brown fox jumps over the dog";
        System.out.println("Checking for: " + validPanagram + " : " + checkPanagram(validPanagram));
        System.out.println("Checking for: " + inValidPanagram + " : " + checkPanagram(inValidPanagram));
    }

    private static boolean checkPanagram(String str) {

        ArrayList<Character> al = new ArrayList<>();
        for (char c : str.toLowerCase().toCharArray()) {
            al.add(c);
        }

        for (int c = 'a'; c < 'z'; c++) {
            char charToCheck = (char) (c);
            //System.out.println("checking for .." + charToCheck);
            if (!al.contains(charToCheck)) {
                //System.out.println(al + " does not contain " + charToCheck);
                return false;
            }
        }

        return true;
    }
}
/*
O/P:
Checking for: The quick brown fox jumps over the lazy dog : true
Checking for: The quick brown fox jumps over the dog : false
 */