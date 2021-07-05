public class Solution59 {
}

class Solution59_1 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0, y = 0;
        int dirIndex = 0;
        int[] curDir = directions[dirIndex % 4];
        int count = 1;

        while (count <= n * n) {
            result[x][y] = count;
            count++;
            x = x + curDir[0];
            y = y + curDir[1];
            if (x == n || x == -1 || y == n || y == -1 || result[x][y] != 0) {
                x = x - curDir[0];
                y = y - curDir[1];
                dirIndex++;
                curDir = directions[dirIndex % 4];
                x = x + curDir[0];
                y = y + curDir[1];
            }
        }
        return result;
    }
}
