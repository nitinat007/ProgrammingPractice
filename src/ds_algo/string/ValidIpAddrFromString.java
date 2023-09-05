package ds_algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: kunitin
 * Created: 03/09/23
 * Info: Given a string containing only digits, restore it by returning all possible valid IP address combinations. Make sure the returned strings are sorted in order. A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 *
 * Below soln is of Time Complexity: O(n^3), space comp: O(n)
 *
 * Can be solved using DP? Solve this. [Time Complexity: O(n), space comp: O(n)]
 **/

public class ValidIpAddrFromString {

    List<String> ipList = new ArrayList();

    public static void main(String[] args) {
        String ip1 = "0100100";
        String[] ips1 = new ValidIpAddrFromString().restoreIpAddresses(ip1);
        System.out.println(Arrays.toString(ips1));


        String ip2 = "11111111";
        String[] ips2 = new ValidIpAddrFromString().restoreIpAddresses(ip2);
        System.out.println(Arrays.toString(ips2));
    }

    public String[] restoreIpAddresses(String A) {
        if (A == null || A.length() < 4) {
            return null;
        }

        for (int i = 1; i < A.length() - 2; i++) {
            String first = A.substring(0, i) + ".";
            for (int j = i + 1; j < A.length() - 1; j++) {
                String second = A.substring(i, j) + ".";
                for (int k = j + 1; k < A.length(); k++) {
                    String third = A.substring(j, k) + ".";
                    String fourth = A.substring(k);
                    String ip = first + second + third + fourth;

                    boolean isValidIp = isValidIp(ip);
                    if (isValidIp == true) {
                        ipList.add(ip);
                    }
                }
            }
        }
        return ipList.toArray(new String[0]);

    }

    public boolean isValidIp(String str) {

        String[] ipParts = str.split("\\.");

        for (String ipPart : ipParts) {
            if (Integer.parseInt(ipPart) > 255 || Integer.parseInt(ipPart) < 0 || ipPart.length() > 3) {
                return false;
            }
            if (ipPart.length() > 1 && (Integer.parseInt(ipPart) == 0 || ipPart.startsWith("0"))) {
                return false;
            }
        }
        return true;
    }
}

/*
OP:
[0.10.0.100, 0.100.10.0]
[1.1.111.111, 1.11.11.111, 1.11.111.11, 1.111.1.111, 1.111.11.11, 1.111.111.1, 11.1.11.111, 11.1.111.11, 11.11.1.111, 11.11.11.11, 11.11.111.1, 11.111.1.11, 11.111.11.1, 111.1.1.111, 111.1.11.11, 111.1.111.1, 111.11.1.11, 111.11.11.1, 111.111.1.1]
 */
