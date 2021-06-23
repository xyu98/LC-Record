package jzoffer;

public class Solution15 {
}

class Solution15_1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String strs = Integer.toBinaryString(n);
        int num = 0;
        for (int i = 0; i < strs.length(); i++) {
            if (strs.charAt(i) == '1') num++;
        }
        return num;
    }
}