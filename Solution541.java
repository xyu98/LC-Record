import java.util.Arrays;

public class Solution541 {
    public static void main(String[] args) {
        Solution541_1 sol = new Solution541_1();
        System.out.println(sol.reverseStr("abcdefg",2));
    }
}

class Solution541_1 {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 1) return s;
        if (k == 1) return s;
        char[] strs = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            reverse(strs, i, Math.min(i + k - 1, s.length() - 1));
            i = i + k * 2;
        }
        StringBuilder res = new StringBuilder();
        for (char str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public void reverse(char[] s, int index1, int index2) {
        if (index2 - index1 < 1) return;
        int left = index1, right = index2;
        char temp;
        while (left < right) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}