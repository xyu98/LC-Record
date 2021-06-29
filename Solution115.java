public class Solution115 {
}

class Solution115_1 {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int i, j;
        for (i = 0; i <= s.length(); i++) dp[i][0] = 1;
        for (j = 1; j <= t.length(); j++) {
            for (i = 1; i <= s.length(); i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}