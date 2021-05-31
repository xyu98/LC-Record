import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public static void main(String[] args) {
        Solution542_1 s = new Solution542_1();
        int[][] matrix = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
        int[][] res = s.updateMatrix(matrix);
    }
}

class Solution542_1 {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] mat) {
        // 准备工作，建立访问记录数组，建立队列并初始化所有节点（）
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // BFS广度遍历，首先想清楚怎么分层，**初始条件是什么**
        // 先把0的情况标记完，所有的0构成第一层
        // 离0距离时1的点构成第二层，距离为2的点构成第三层，...
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j}); // 将当前层（初始层）的所有节点入队
                }
            }
        }

        // 从这里开始BFS的过程
        // 只要队列不空，就在队列当前长度范围内重复”一个节点出队，其相邻节点全部入队“的过程
        int cost = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];
                // 如果找到1
                if (mat[i][j] == 1) {
                    res[i][j] = cost;
                }

                // 从当前节点继续往四周搜索
                for (int[] dir: dirs) {
                    int x = i + dir[0], y = j + dir[1];
                    // 判断当前点是否符合要求，符合则入队
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            cost++;
        }
        return res;
    }
}