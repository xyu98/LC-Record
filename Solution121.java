public class Solution121 {
}

// 解1：动规 复杂度较高
class Solution121_1 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[][] dp = new int[prices.length][2]; //[i][0]持有 [i][1]不持有
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1]; // 最后一天不持有股票状态所得金钱⼀定⽐持有股票状态得到的多
    }
}

// 解2：本题用贪心较简单
class Solution121_2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int res = 0, low = Integer.MAX_VALUE;
        for (int price : prices) {
            low = Math.min(low, price);
            res = Math.max(res, price - low);
        }
        return res;
    }
}