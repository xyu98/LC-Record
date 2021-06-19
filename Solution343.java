public class Solution343 {
    public static void main(String[] args) {
        Solution343_1 s = new Solution343_1();
        System.out.println(s.integerBreak(10));
    }
}

class Solution343_1 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        // 比较难的是递推公式，也就是dp[i]怎么得到
        // 两个数相乘：dp[i] = j * (i - j)
        // 多个数相乘：dp[i] = j * dp[i - j]，也就是将i - j继续拆分
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j])); //特别注意这里
            }
        }
        return dp[n];
    }
}