public class Solution27 {
    public static void main(String[] args) {
        Solution27_3 s = new Solution27_3();
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] nums3 = {3, 2, 2, 3};
        int[] nums4 = {4, 5};
        int[] nums5 = {};
        int count = 0;
        count = s.removeElement(nums2, 2);
        for (int k = 0; k < count; k++) {
            System.out.println(nums2[k]);
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

// 2021.6.30 review
class Solution27_review1 {
    public int removeElement(int[] nums, int val) {
        int i, j, res = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == val) res++;
        }
        for (i = 0; i < nums.length - res; i++) {
            if (nums[i] == val) {
                j = i + 1;
                while (nums[j] == val) j++;
                swap(nums, i, j);
            }
        }
        return nums.length - res;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp;
        temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

class Solution27_3 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        int count = 0;
        while (fast < nums.length) {
            nums[slow] = nums[fast];
            while (fast < nums.length && nums[fast] == val) {
                fast++;
                count++;
                if (fast < nums.length) nums[slow] = nums[fast];
            }
            slow++;
            fast++;
        }
        return nums.length - count;
    }
}

// 最优版本
class Solution27_4 {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int fastIndex = 0;
        int slowIndex;
        for (slowIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}