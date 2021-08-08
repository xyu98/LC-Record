import java.util.*;

public class Solution347 {
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
            // 或者写成一句 map.put(num, map.geiOrDefault(num, 0) + 1));
        }
        // 建立一个优先队列，并手动实现Comparator接口，升序排列，使头部元素的关键字最小
        // queue中的每一个元素都是一个int[2]数组，第一个元素代表数组的值，第二个元素代表了该值出现的次数
        // queue的作用就是存放：将Map中的键值对按照值升序排列后的键值对（键值对存储为数组形式）
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        // 遍历Map的方法。Map中采用Entry内部类来表示一个映射项
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue(); // 获取当前键值对的key和value
            if (queue.size() == k) {
                // 如果队列中有k个元素但是优先队列头部元素的count小于当前的count
                // 说明当前queue的头部元素不是出现次数最多的，因此将当前头部从队列删除并将新的元素入列
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count}); // 队列不足k个元素，向队列中添加元素至k个
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}