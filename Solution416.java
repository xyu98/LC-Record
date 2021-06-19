public class Solution416 {
}

class Solution416_1 {
    public boolean canPartition(int[] nums) {
        int sum = 0, target = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        else target = sum / 2;
        int[] dp = new int[10001];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}