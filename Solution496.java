import java.util.Stack;

public class Solution496 {
    public static void main(String[] args) {
        Solution496_2 s = new Solution496_2();
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        for (int x: s.nextGreaterElement(nums1, nums2)) {
            System.out.println(x);
        }
    }
}

// 第1次提交，执行用时: 5 ms（超过82.77%），内存消耗: 38.6 MB MB（超过56.60%）
// 最暴力的解法，采用for循环层层嵌套。用while可以使代码简洁（减小时间复杂度），但是没有改变时间空间复杂度。
class Solution496_1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int index = 0;
        boolean flag;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                flag = false;
                if (nums1[i] == nums2[j]) {
                    if (j == nums2.length - 1) {
                        result[index] = -1;
                        index++;
                        break;
                    }
                    else {
                        for (int k = j + 1; k < nums2.length; k++) {
                            if (nums2[k] > nums1[i]) {
                                result[index] = nums2[k];
                                index++;
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            result[index] = -1;
                            index++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return result;
    }
}

// 解2：两层循环，时间复杂度O(MN).
// 时间复杂度和空间复杂度都较小，是比较优的解法
class Solution496_2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[] res = new int[len1];
        if (len1 < 1) {
            return res;
        }

        for (int i = 0; i < len1; i++) {
            int curVal = nums1[i];
            int j = 0;
            while (j < len2 && nums2[j] != curVal) {
                j++;
            }

            // 此时 nums[j] = nums[i]
            j++;
            while (j < len2 && nums2[j] < curVal) {
                j++;
            }

            if (j == len2) {
                res[i] = -1;
                continue;
            }
            res[i] = nums2[j];
        }
        return res;
    }
}

// 解3：执行用时: 146 ms（超过5.01%），内存消耗: 38.6 MB MB（超过67.45%）——时间复杂度太高
// 本题只关注每个目标元素右面（后面）的元素，可以利用栈“后面的元素先操作”的特性
// 将nums2存入栈stack中。目标元素后面的元素要逐个弹出进行比较，弹出来的元素存入另一个栈temp
// 当前目标处理结束后，将temp中的元素再恢复到stack中，进行下一个目标的处理
class Solution496_3 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int target;
        boolean isFound;

        for (int x:nums2) {
            stack.push(x);
        }

        for (int i = 0; i < nums1.length; i++) {
            isFound = false;
            while (!stack.isEmpty() && stack.peek() != nums1[i]) {
                temp.push(stack.pop());
            }
            target = nums1[i];
            while (!temp.isEmpty()) {
                if (temp.peek() > nums1[i]) {
                    target = temp.peek();
                    isFound = true;
                    break;
                }
                else {
                    stack.push(temp.pop());
                }
            }
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            if (isFound) {
                result[i] = target;
            }
            else {
                result[i] = -1;
            }
        }
        return result;
    }
}

/*
// 解4：
// 哈希表实现
class Solution496_4 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    }
}

 */