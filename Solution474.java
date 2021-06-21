public class Solution474 {
}

// 转化为背包问题：str[i]就是物品，每个字符串str[i]中包含的m和n的个数就是重量（两个维度）
// 字符串的个数就是物品的价值（不好想，物品价值通常就是要求的东西,也就是最后返回的东西）
// 本质是有两个维度的01背包
// 在原来的框架基础上加一个维度（加一个for循环遍历strs中的元素）
class Solution474_1 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroNum = 0, oneNum = 0;
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == '0') zeroNum++;
                if (str.charAt(k) == '1') oneNum++;
            }
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}