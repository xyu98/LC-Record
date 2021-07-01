import java.util.Arrays;

public class Solution977 {
}

// 不讲武德解法
class Solution977_1 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int)Math.pow(nums[i], 2);
        }
        return nums;
    }
}

// 双指针法
// 因为数组已经排过序了，因此最大值一定在两端取得，不可能在中间
class Solution977_2 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int len = nums.length;
        int i = len - 1, j = 0;
        int k = len - 1;
        while (j <= i) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k] = nums[i] * nums[i];
                k--;
                i--;
            }
            else {
                result[k] = nums[j] * nums[j];
                k--;
                j++;
            }
        }
        return result;
    }
}