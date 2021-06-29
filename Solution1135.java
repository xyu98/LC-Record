public class Solution1135 {
    public static void main(String[] args) {
        int[] nums1 = {2,5,1,2,5};
        int[] nums2 = {10,5,2,1,5,2};
        Solution1135_1 s = new Solution1135_1();
        System.out.println(s.maxUncrossedLines(nums1, nums2));
    }
}

class Solution1135_1 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int i, j;
        for (i = 1; i <= nums1.length; i++) {
            for (j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[nums1.length][nums2.length];
    }
}