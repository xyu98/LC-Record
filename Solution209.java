public class Solution209 {
}

class Solution209_1 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0;
        int result = 10001;
        int subLength = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                sum -= nums[i++];
            }
        }
        return result == 10001 ? 0 : result;
    }
}