import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args) {
        Solution1_1 s = new Solution1_1();
        int[] nums = {3,2,4};
        s.twoSum(nums,6);
    }
}

// 暴力解法的复杂度是O(N^2)，最好别用
// 可以利用Map求解
class Solution1_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;
        HashMap<Integer, Integer> search = new HashMap<>();
        int searchTarget;
        for (int i = 0; i < nums.length; i++) {
            searchTarget = target - nums[i];
            if (search.containsKey(searchTarget)) {
                res[0] = i;
                res[1] = search.get(searchTarget);
            }
            search.put(nums[i], i);
        }
        return res;
    }
}