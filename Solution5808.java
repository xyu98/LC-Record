public class Solution5808 {
}

class Solution5808_1 {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i % nums.length];
        }
        return res;
    }
}