public class Solution27 {
    public static void main(String[] args) {
        Solution27_2 s = new Solution27_2();
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums3 = {3, 2, 2, 3};
        int[] nums4 = {3, 3};
        int[] nums5 = {};
        int count = 0;
        count = s.removeElement(nums5, 3);
        for (int k = 0; k < count; k++) {
            System.out.println(nums5[k]);
        }
    }
}

// 第1次提交，执行用时: 0 ms（超过100%），内存消耗: 36.9 MB MB（超过83.09%）
class Solution27_1 {
    public int removeElement(int[] nums, int val) {
        int i;
        int count = 0;
        // 判断一下是否为空是可以节约内存的！！！
        if (nums == null) {
            return 0;
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }
}

// 第2次提交：采用双指针法，i从前往后找value，j从后往前找不等于value，两者置换
// 这个方法还行，没有上面的好
// 因为本题中不要求输出元素的顺序，因此只要把不等于value的元素移到前面即可
// 停止条件是 i = j
// 第2次提交，执行用时: 0 ms（超过100%），内存消耗: 37 MB（超过64.22%）
class Solution27_2 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        int temp;

        if (nums.length == 0) {
            return 0;
        }

        while (i < j) {
            while (i < j && nums[i] != val) {
                i++;
            }
            while (i < j && nums[j] == val) {
                j--;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        if (nums[i] == val)
            return i;
        else
            return i + 1;
    }
}