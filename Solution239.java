import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution239 {
}

class Solution239_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 定义比较的规则
        // [0]位置是值的大小，[1]的位置是下标。先按值由小到大，如果值一样大就按下标由小到大
        // 下标是为了判断当前优先队列pq的最大值是否再滑动窗口中
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        // 初始时，将数组 nums 的前 k 个元素放入优先队列中
        // 核心就是，pq中顶端元素（将要出队的元素）永远是最大的
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1]; // 存放最终结果
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            // 每当向右移动窗口时，就把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值
            pq.offer(new int[]{nums[i], i});
            // 然而这个最大值可能并不在滑动窗口中，在这种情况下，这个值在数组 nums 中的位置出现在滑动窗口左边界的左侧
            while (pq.peek()[1] <= i - k) {
                pq.poll(); // 这个值永远不可能出现在滑动窗口中了，将其永久地从优先队列中移除
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}