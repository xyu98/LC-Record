import java.util.*;

public class Solution15 {
}

// 这个解法本质上还是哈希法，不容易去重
class Solution15_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int sumAB, pos;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sumAB = nums[i] + nums[j];
                pos = Arrays.binarySearch(nums, -sumAB);
                if (pos >= 0 && pos != i && pos != j) {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[pos]);
                    result.add(path);
                }
            }
        }
        return result;
    }
}

// 双指针法
class Solution15_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int left, right;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) return result;
            // 这一步去重，非常重要！！
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            left = i + 1;
            right = nums.length - 1;
            while (right > left) {
                // 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
                /*
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                */
                if (nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else {
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    result.add(path);
                    // 去重逻辑应该放在找到一个三元组之后
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    // 找到答案时，双指针同时收缩
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}