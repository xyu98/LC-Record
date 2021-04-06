import java.util.*;

public class Solution283 {
    public static void main(String[] args) {
        Solution283_3 s = new Solution283_3();
        int[] nums1 = {0, 1, 0, 3, 12};
        int[] nums2 = {1, 0, 0, 1, 1, 0, 1};
        s.moveZeroes(nums1);
    }
}

// 可以输出正确结果，但是没有在原数组上操作，所以没过
class Solution283_1 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        // 试图将数组转化为LinkedList
        // LinkedList list1 = new LinkedList<>(Arrays.asList(nums));
        // 这样的结果是Arrays.asList()方法会把整个int[]数组当成List中的一个元素，不符合本意

        // 注意如果 LinkedList<Integer> list1 = Arrays.asList(nums);
        // 则这样的LinkedList是Arrays类的静态内部类（java.util.Arrays.ArrayList类）
        // 并不是java.util.ArrayList类

        // 采用如下方式
        LinkedList<Integer> list1 = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list1.add(nums[i]);
        }

        Iterator it1 = list1.iterator();

        while (it1.hasNext()) {
            if (it1.next().equals(0)) {
                it1.remove();
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            list1.add(0);
        }

        // 按格式输出数组
        System.out.print("[");
        Iterator it2 = list1.iterator();
        count = 0;
        while (it2.hasNext() && count != list1.size() - 1) {
            System.out.print(it2.next() + ",");
            count++;
        }
        System.out.print(it2.next() + "]");
    }
}

// 思路：找0的位置，并首先先判断连续0的个数，对于连续0比较多的情况有利
// 执行用时：7 ms（超过8.24%），内存消耗：38.4 MB（超过97.73%）

class Solution283_2 {
    public void moveZeroes(int[] nums) {
        int flag = 0;
        int zero_num = 0;
        int i, j, k;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0)
                        break;
                }
                zero_num = j - i;
                for (k = j; k < nums.length; k++) {
                    nums[k - zero_num] = nums[k];
                }
                for (k = 1; k <= zero_num; k++) {
                    nums[nums.length - k] = 0;
                }
            }
        }
        // 不用输出
    }
}

// 变换思路，找非零元素的位置，从数组的0位置依次往后放
// 执行用时：0 ms（超过100%），内存消耗：38.9 MB（超过22.61%）
class Solution283_3 {
    public void moveZeroes(int[] nums) {
        int i, index = 0;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
            else
                nums[i] = 0;
        }
        for (i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int x: nums) {
            System.out.println(x);
        }

    }
}