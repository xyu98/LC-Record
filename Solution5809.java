import java.util.HashSet;

public class Solution5809 {
    public static void main(String[] args) {
        String s = "uuuuu";
        Solution5809_2 sol = new Solution5809_2();
        System.out.println(sol.countPalindromicSubsequence(s));
    }
}

// 超时
class Solution5809_1 {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> set1 = new HashSet<>();
        int res = 0;
        int i, j;
        for (i = 0; i < s.length() - 2; i++) {
            if (!set1.add(s.charAt(i))) continue;
            HashSet<Character> set2 = new HashSet<>();
            for (j = i + 2; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    for (int k = i + 1; k < j; k++) {
                        if (set2.add(s.charAt(k))) res++;
                    }
                }
            }
        }
        return res;
    }
}

// 思路和上个解法相近，通过技巧化掉一重循环（变成两重）
// 利用字母有限（26）的特点
class Solution5809_2 {
    public int countPalindromicSubsequence(String s) {
        int res = 0;
        for (int i = 0; i < 26; i++) {
            char curChar = (char)('a' + i);
            HashSet<Character> set = new HashSet<>();
            int low = 0, high = s.length() - 1;
            while (low < s.length() && s.charAt(low) != curChar) low++;
            while (high > -1 && s.charAt(high) != curChar) high--;
            if (low >= high - 1) continue;
            for (int k = low + 1; k < high; k++) {
                if (set.add(s.charAt(k))) res++;
            }
        }
        return res;
    }
}
