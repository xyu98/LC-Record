public class Solution746 {
    public static void main(String[] args) {
        Solution746_1 s = new Solution746_1();
        int[] cost = {10,15,20};
        System.out.println(s.minCostClimbingStairs(cost));;
    }
}

class Solution746_1 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        if (len == 1) return dp[0];
        dp[1] = cost[1];
        if (len == 2) return Math.min(dp[0],dp[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
}