public class Solution26 {
    public static void main(String[] args) {
        Solution26_2 s = new Solution26_2();
        int[] nums = {1,1,2,2};
        System.out.println(s.removeDuplicates(nums));
        for (int x: nums) {
            System.out.print(x + " ");
        }
    }
}

// 解1：时间O(NN)空间O(1)
// 232 ms (5%) 40.2 MB (73.79%) 可优化空间很大！！
class Solution26_1 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int len = nums.length;
        int max = nums[nums.length - 1];
        int cnt, i, j, k;
        boolean flag;
        for (i = 0; i < len - 1; i++) {
            // 先判断有几个要删除
            flag = false;
            cnt = 0;
            j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                cnt++;
                j++;
                len--;
                flag = true;
            }
            k = j;
            while (k < nums.length && flag) {
                nums[k - cnt] = nums[k];
                nums[k] = Integer.MAX_VALUE;
                k++;
            }
        }
        return len;
    }
}

// 解2，高效的双指针!!!
// 时间O(N) 空间O(1)
class Solution26_2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
