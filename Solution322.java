import java.util.Arrays;

public class Solution322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        Solution322_1 s = new Solution322_1();
        System.out.println(s.coinChange(coins,5));
    }
}

class Solution322_1 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 需要的硬币个数不会超过10001
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != 10001) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }
}