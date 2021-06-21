public class Solution518 {
    public static void main(String[] args) {
        Solution518_1 s = new Solution518_1();
        int[] coins = {1,2,5};
        System.out.println(s.change(5,coins));
    }
}

class Solution518_1 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}