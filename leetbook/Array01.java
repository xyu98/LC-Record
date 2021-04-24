package leetbook;

import java.util.ArrayList;

public class Array01 {
    public static void main(String[] args) {
        Solution_Array01 s = new Solution_Array01();
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(s.pivotIndex(nums));
    }
}

// 时间O(N)空间O(N)
// 69.8% 99.61%
class Solution_Array01 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int[] sum1 = new int[nums.length];
        int[] sum2 = new int[nums.length];
        int sums = 0, i, j, k;
        for (i = 0; i < nums.length; i++) {
            sums = sums + nums[i];
            sum1[i] = sums;
        }
        sums = 0;
        for (j = nums.length - 1; j > -1; j--) {
            sums = sums + nums[j];
            sum2[j] = sums;
        }
        if (sum2[1] == 0) return 0;
        for (k = 0; k < nums.length - 2; k++) {
            if (sum1[k] == sum2[k + 2]) return k + 1;
        }
        if (sum1[k] == 0) return nums.length - 1;
        else return -1;
    }
}