public class Solution55 {
    public static void main(String[] args) {
        Solution55_1 s = new Solution55_1();
        int[] nums = {3,2,1,0,4};
        s.canJump(nums);
    }
}

class Solution55_1 {
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            cover = Math.max(nums[i] + i, cover);
            if (cover >= nums.length - 1) return true;
        }
        return false;
    }
}