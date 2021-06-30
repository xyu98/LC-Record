public class Solution647 {
}

class Solution647_1 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int i, j, res = 0;
        for (i = s.length() - 1; i >= 0; i--) {
            for (j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(i)) dp[i][j] = false;
                else if (i == j || j == i + 1) {
                    dp[i][j] = true;
                    res++;
                }
                else if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}