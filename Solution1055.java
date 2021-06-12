import java.util.Arrays;

public class Solution1055 {
    public static void main(String[] args) {
        Solution1055_2 s = new Solution1055_2();
        int[] nums = {-8,3,-5,-3,-5,-2};
        int k = 6;
        System.out.println(s.largestSumAfterKNegations(nums, k));
    }
}

// 不管哪种解法，思想都是贪心
// 先把负数全反过来，如果K还⼤于0，那么反复转变数值最⼩的元素，将K⽤完
// 解1：常规思路
class Solution1055_1 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int flip = 0, i = 0;
        int flag;
        int minNegativeIndex = 0, minPositiveIndex = 0;
        while (flip < k) {
            flag = 0;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] < 0 && nums[i] <= nums[minNegativeIndex]) {
                    minNegativeIndex = i;
                    flag = 1;
                }
            }
            if (flag == 1) {
                nums[minNegativeIndex] = -nums[minNegativeIndex];
                flip++;
                continue;
            }
            for (i = 0; i < nums.length; i++) {
                if (nums[i] >= 0 && nums[i] <= nums[minPositiveIndex]) {
                    minPositiveIndex = i;
                    flag = 1;
                }
            }
            if (flag == 1) {
                nums[minPositiveIndex] = -nums[minPositiveIndex];
                flip++;
            }
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

// 解2：先排序，降低后续处理的复杂度
// 解3：很巧妙，排序的时候按照**绝对值大小**进行排序
class Solution1055_2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while (nums[i] < 0 && k > 0) {
            nums[i] *= -1;
            i++;
            k--;
        }
        Arrays.sort(nums);
        i = 0;
        while (k > 0) {
            nums[i] *= -1;
            //i++; 这里i就不要增加了，反复将k消耗完即可
            k--;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}