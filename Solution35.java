public class Solution35 {
    public static void main(String[] args) {
        Solution35_1 s = new Solution35_1();
        int[] nums = {1,3,5,6};
        System.out.println(s.searchInsert(nums, 9));
    }
}

// 二分，时间100%，空间72.55%
class Solution35_1 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
            mid = (low + high) / 2;
        }
        if (nums[mid] > target) return Math.max(mid - 1, 0);
        else return mid + 1;
    }
}