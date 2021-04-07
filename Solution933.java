import java.util.LinkedList;

public class Solution933 {
    public static void main(String[] args) {
        // 测试程序不好写，直接在LeetCode控制台测试
        RecentCounter_1 recentCounter = new RecentCounter_1();
        recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
        recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }
}

// 第1次提交，执行用时: 2165 ms（超过5.08%），内存消耗: 46.4 MB（超过91.03%）
class RecentCounter_1 {
    LinkedList<Integer> request = new LinkedList<>();
    public RecentCounter_1() {
        // 构造方法 初始化计数器，请求数为0
    }

    public int ping(int t) {
        request.add(t);
        int count = 0;
        for (Integer x: request) {
            if (x >= t - 3000) {
                count++;
            }
        }
        return count;
    }
}