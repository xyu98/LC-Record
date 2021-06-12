import java.util.*;

public class Solution491 {
    public static void main(String[] args) {
        Solution91_1 s = new Solution91_1();
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        s.findSubsequences(nums);
    }
}

// 解1: 没通过，无法完全查重
class Solution91_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int count = 0;

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(0, nums);
        return res;
    }

    public void backtracking(int startIndex, int[] nums) {
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) continue;
            if (isContains(nums, 0, i - 1) && count == 0) continue;
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                count++;
                if (count >= 2) {
                    res.add(new LinkedList<>(path));
                }
                backtracking(i + 1, nums);
                count--;
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isContains(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == nums[end + 1]) return true;
        }
        return false;
    }
}

// 解2：利用set去重！！
class Solution91_2 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    int count = 0;

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums.length == 0) return res;
        backtracking(0, nums);
        return res;
    }

    public void backtracking(int startIndex, int[] nums) {
        if (startIndex >= nums.length) {
            return;
        }
        Set<Integer> uset = new HashSet<>(); // 进行去重，注意初始化的位置在for循环之外
        for (int i = startIndex; i < nums.length; i++) {
            if (uset.contains(nums[i])) continue;
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                path.add(nums[i]);
                uset.add(nums[i]);
                count++;
                if (count >= 2) {
                    res.add(new LinkedList<>(path));
                }
                backtracking(i + 1, nums);
                count--;
                path.remove(path.size() - 1);
            }
        }
    }
}