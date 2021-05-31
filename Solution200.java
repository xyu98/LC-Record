public class Solution200 {
}

class Solution200_1 {
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++; // 只要找到一个没有搜索过的”1“，说明找到了一个新的岛屿
                    dfs(grid, i, j); // 将这个1相连的1（整个岛屿）全部遍历一遍，需要进行的操作就是标记
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        grid[i][j] = '0'; // 每搜索到一个1就将它设为0（一种标记visited的trick）
        for (int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= grid.length || y < 0
                    || y >= grid[i].length || grid[x][y] == '0') continue;
            dfs(grid, x, y);  // 如果符合要求，由这个点继续dfs
        }
    }
}