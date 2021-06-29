public class Solution718 {
}

class Solution718_1 {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        dp[0][0] = 0;
        int i, j;
        int result = 0;
        for (i = 1; i <= nums1.length; i++) {
            for (j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}