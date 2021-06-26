public class Solution122 {
    public static void main(String[] args) {
        Solution122_2 s = new Solution122_2();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}

// 解1：贪心，只收集每天的正利润
class Solution122_1 {
    public int maxProfit(int[] prices) {
        int[] profit = new int[prices.length - 1];
        int partialProfit = 0;
        int res = 0;
        int j = 0;
        for (int i = 1; i < prices.length; i++) {
            profit[j] = prices[i] - prices[i - 1];
            if (profit[j] > 0) res += profit[j];
            j++;
        }
        return res;
    }
}

// 解2：动规
class Solution122_2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]); // 多次买卖和单次的不同之处，要加上之前的利润
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}