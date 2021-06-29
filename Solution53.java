public class Solution53 {
    public static void main(String[] args) {
        Solution53_2 s = new Solution53_2();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
    }
}

class Solution53_1 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int res = -10001;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > res) res = sum;
            if (sum < 0) sum = 0;
        }
        return res;
    }
}

class Solution53_2 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(dp[i], result);
        }
        return result;
    }
}