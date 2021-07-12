package jzoffer;

public class Solution58_2nd {
}

class Solution58_2nd_1 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.append(s.charAt((i + n) % s.length()));
        }
        return res.toString();
    }
}

class Solution58_2nd_2 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
