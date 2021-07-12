public class Solution1920 {
    public static void main(String[] args) {
        int[] nums = {0,2,1,5,3,4};
        Solution1920_1 sol = new Solution1920_1();
        int[] res = sol.buildArray(nums);
        for (int x : res) {
            System.out.println(x);
        }
    }
}

class Solution1920_1 {
    public int[] buildArray(int[] nums) {
        if (nums == null) return null;
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = nums[nums[i]];
        }
        return results;
    }
}