public class Solution485 {
    public static void main(String[] args) {
        Solution485_1 s = new Solution485_1();
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(s.findMaxConsecutiveOnes(nums2));
    }
}

// 第1次提交，执行用时: 2 ms（超过90%），内存消耗: 40.1 MB（超过28%）
// 内存消耗比较大
class Solution485_1 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // 注意一下空的情况
        if (nums == null) {
            return 0;
        }
        int count = 0;  // 计数
        int number = 0; // 最终结果
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (i == nums.length - 1 && count > number) {
                    return count;
                }
            }
            else if (count > number) {
                number = count;
                count = 0;
            }
            else
                count = 0;
        }
        return number;
    }
}