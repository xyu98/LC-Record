public class Solution459 {
    public static void main(String[] args) {
        Solution459_2 s = new Solution459_2();
        System.out.println(s.repeatedSubstringPattern("ab"));
    }
}

// 常规思路
class Solution459_1 {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;
        if (s.length() == 2 && s.charAt(0) != s.charAt(1)) return false;
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.length() % (i + 1) == 0) {
                if (judge(s.substring(0, i + 1), s)) return true;
            }
        }
        return false;
    }

    public boolean judge(String sub, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (sub.charAt(i % sub.length()) != s.charAt(i)) return false;
        }
        return true;
    }
}

// KMP的前后缀思想，比较难想
// 数组长度 减去 最长相同前后缀的长度 相当于是第一个周期的长度，也就是”一个周期的长度“
// 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
class Solution459_2 {
    public boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) j = next[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
        int len = s.length();
        return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
    }
}