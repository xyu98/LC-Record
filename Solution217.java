import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public static void main(String[] args) {
        Solution217_3 s = new Solution217_3();
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 0, 1, 1, 0, 1};
        System.out.println(s.containsDuplicate(nums2));
    }
}

// 典型的trade off，时间空间无法同时做到最优！

// 解法1：时间 6 ms（超过58.05%），内存 45.5 MB（超过12.91%） 时间O(N)，空间O(N)
class Solution217_1 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x: nums) {
            set.add(x);
        }
        return nums.length != set.size();
    }
}

// 解2：时间 7 ms（超过46.35%），内存 42.5 MB（超过59.73%） 时间O(N)，空间O(N)
// 优化了内存占用（提前终止）。因为多了一次if判断，因此时间变长了（但时间复杂度不变）
class Solution217_2 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (i + 1 != set.size()) return true;
        }
        return false;
    }
}

// 解3：超出时间限制！！！ 时间O(NN)，空间O(1)
// 拿时间换空间
class Solution217_3 {
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}

