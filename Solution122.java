public class Solution122 {
    public static void main(String[] args) {
        Solution122_1 s = new Solution122_1();
        int[] prices = {7,1,5,3,6,4};
        s.maxProfit(prices);
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