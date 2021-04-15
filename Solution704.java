public class Solution704 {
    public static void main(String[] args) {
        Solution704_1 s = new Solution704_1();
        int[] nums = {};
        System.out.println(s.search(nums, 9));
    }
}

// 普通二分查找，时间O(log2(N)),空间O(1)
class Solution704_1 {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
            mid = (low + high) / 2;
        }
        return -1;
    }
}

// 暴力搜索
class Solution704_2 {
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }
}