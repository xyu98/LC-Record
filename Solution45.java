public class Solution45 {
    public static void main(String[] args) {
        Solution45_2 s = new Solution45_2();
        int[] nums = {2,3,1,1,4};
        System.out.println(s.jump(nums));;
    }
}

// 没写出来，思路完全不对
class Solution45_1 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int res = 0, curMaxIndex = 0, tempIndex = 0;
        int curMaxJump = nums[0], tempMax = nums[0];
        while (nums[curMaxIndex] < nums.length - curMaxIndex - 1) {
            int plus = 0;
            for (int j = curMaxIndex; j <= curMaxJump + curMaxIndex; j++) {
                if (nums[j] + plus > tempMax) {
                    tempMax = nums[j];
                    tempIndex = j;
                }
                if (nums[tempIndex] >= nums.length - tempIndex - 1) return res + 2;
                plus++;
            }
            res++;
            curMaxIndex = tempIndex;
            curMaxJump = tempMax;
        }
        return res + 1;
    }
}

//
class Solution45_2 {
    public int jump(int[] nums) {
        int curIndex = 0, nxtIndex = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            nxtIndex = Math.max(nums[i] + i, nxtIndex);
            if (i == curIndex) {  // 这一步判断很巧妙，从根本上避免了用第二层循环寻找最大值
                if (curIndex != nums.length - 1) {
                    res++;
                    curIndex = nxtIndex;
                    if (nxtIndex >= nums.length - 1) break;
                }
                else break;
            }
        }
        return res;
    }
}