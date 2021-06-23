import java.util.Arrays;

public class Solution213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution213_2 s=  new Solution213_2();
        System.out.println(s.rob(nums));
    }
}

// 解1
class Solution213_1 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robPart(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                robPart(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robPart(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1]=  Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}

// 解2：和解1思路相同，但是没有复制数组，只是传递了下标
class Solution213_2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robPart(nums, 0, nums.length - 2),
                robPart(nums, 1, nums.length - 1));
    }

    public int robPart(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        if (start == end) return nums[start];
        dp[start] = nums[start];
        dp[start + 1]=  Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}