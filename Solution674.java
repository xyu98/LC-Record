public class Solution674 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        Solution674_2 s = new Solution674_2();
        System.out.println(s.findLengthOfLCIS(nums));
    }
}

// 双指针直接解
// 更新：一个指针就够用了，j完全没用到
class Solution674_1 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int result = 0, len = 1;
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] < nums[j]) {
                i++;
                j++;
                len++;
            }
            else {
                i = j;
                j++;
                result = Math.max(result, len);
                len = 1;
            }
        }
        return Math.max(result, len);
    }
}

// 动规
class Solution674_2 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int result = 1, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                len++;
                dp[i] = Math.max(dp[i - 1] + 1, len);
            }
            else len = 1;
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}