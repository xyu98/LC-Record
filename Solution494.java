public class Solution494 {
}

class Solution494_1 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        int dpTarget;
        if ((sum + target) % 2 != 0) return 0;
        else dpTarget = (sum + target) / 2;
        int[] dp = new int[1001];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dpTarget; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[dpTarget];
    }
}