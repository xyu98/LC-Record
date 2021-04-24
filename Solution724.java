public class Solution724 {
    public static void main(String[] args) {
        Solution724_2 s = new Solution724_2();
        int[] nums = {-1,-1,0,1,1,0};
        System.out.println(s.pivotIndex(nums));
    }
}

class Solution724_1 {
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

// 解2：方案很巧妙（但是复杂度是一样的）
class Solution724_2 {
    public int pivotIndex(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];

        for(int i = 1; i < nums.length; i++){
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            suf[i] = suf[i + 1] + nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++){
            if(pre[i] == suf[i]) return i;
        }
        return -1;
    }
}