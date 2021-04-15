public class Solution162 {
    public static void main(String[] args) {
        Solution162_1 s = new Solution162_1();
        int[] nums = {1,2,3,4};
        System.out.println(s.findPeakElement(nums));
    }
}

// 解1：直接搜索，时间O(N),空间O(1)
// 还可优化
class Solution162_1 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        if (nums[0] > nums[1]) return 0;
        else return nums.length - 1;
    }
}

// 解2：解1的优化
class Solution162_2 {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}