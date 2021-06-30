import java.util.Arrays;

public class Solution516 {
}

// 动规
// 只要回文串加了限定条件，一般没法用双指针
class Solution516_1 {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1) return 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        } // 因为递推公式算不到i，j相同的情况
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}