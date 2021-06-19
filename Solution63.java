public class Solution63 {
}

class Solution63_1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i, j;
        for (i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) dp[i][0] = 1;
            else break;
        }
        for (j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (obstacleGrid[i][j - 1] == 1) dp[i][j - 1] = 0;
                if (obstacleGrid[i - 1][j] == 1) dp[i - 1][j] = 0;
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return obstacleGrid[m - 1][n - 1] == 1 ? 0 : dp[m - 1][n - 1];
    }
}

// 解1-1：和上面一个思路，代码进行了简化，复杂度是相同的
class Solution63_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int i, j;
        for (i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
        for (j = 0; j < n && obstacleGrid[0][j] == 0; j++) dp[0][j] = 1;
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}