public class Solution62 {
    public static void main(String[] args) {
        Solution62_1 s = new Solution62_1();
        System.out.println(s.uniquePaths(3,7));
    }
}

class Solution62_1 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int i, j;
        // 初始化，在两条边上一定只有一条路径
        // 不能只初始化原点
        for (i = 0; i < m; i++) dp[i][0] = 1;
        for (j = 0; j < n; j++) dp[0][j] = 1;
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}