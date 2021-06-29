import java.util.Arrays;

public class Solution300 {
    public static void main(String[] args) {
        Solution300_1 s = new Solution300_1();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(s.lengthOfLIS(nums));
    }
}

class Solution300_1 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {  // 两层循环判断当前nums[i]是否大于nums[0,i-1]中的值
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            if (dp[i] > result) result = dp[i]; // 取最长的
        }
        return result;
    }
}