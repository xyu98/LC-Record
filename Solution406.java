import java.util.Arrays;
import java.util.Comparator;

public class Solution406 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution406_1 s = new Solution406_1();
        s.reconstructQueue(people);
    }
}

// 解1：时间O(N^2), 空间O(log2N)即排序需要使用的栈空间
class Solution406_1 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][];
        // 自定义sort排序，相当于实现了Comparator接口中的compare方法
        // 先按身高排序
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0]; // 按第0位元素升序
                } else {
                    return person2[1] - person1[1]; // 按第1位元素降序
                }
            }
        });
        // 放置的过程（两重循环）
        for (int[] person : people) { // 需要放置的元素
            int position = person[1] + 1;
            for (int j = 0; j < people.length; j++) {  // 最关键的部分：找它的位置（第position个没有元素的位置）
                if (res[j] == null) {
                    position--;
                    if (position == 0) {
                        res[j] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }
}