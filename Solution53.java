public class Solution53 {
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