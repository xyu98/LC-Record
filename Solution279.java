import java.util.Arrays;

public class Solution279 {
    public static void main(String[] args) {
        Solution279_1 s = new Solution279_1();
        System.out.println(s.numSquares(11));
    }
}

class Solution279_1 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}