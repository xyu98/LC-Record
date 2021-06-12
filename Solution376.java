public class Solution376 {
}

class Solution376_1 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int cnt = 1; // 默认最右边有一个峰值
        int preDiff = 0, curDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0) && (preDiff >= 0)) {
                cnt++;
                preDiff = curDiff;
            }
        }
        return cnt;
    }
}