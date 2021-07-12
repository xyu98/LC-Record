import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    public static void main(String[] args) {
        //int[] nums = {1,0,-1,0,-2,2};
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        Solution18_1 s = new Solution18_1();
        s.fourSum(nums,-11);
    }
}

class Solution18_1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        int left, right;
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = nums.length - 1; j > i + 2; j--) {
                if ((i > 0 && nums[i] == nums[i - 1]) || (j < nums.length - 1 && nums[j] == nums[j + 1])) continue;
                left = i + 1;
                right = j - 1;
                while (right > left) {
                    if (nums[i] + nums[left] + nums[right] + nums[j] > target) right--;
                    else if (nums[i] + nums[left] + nums[right] + nums[j] < target) left++;
                    else {
                        List<Integer> path = new ArrayList<>();
                        path.add(nums[i]);
                        path.add(nums[left]);
                        path.add(nums[right]);
                        path.add(nums[j]);
                        result.add(path);
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}