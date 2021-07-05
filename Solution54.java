import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution54_1 s = new Solution54_1();
        System.out.println(s.spiralOrder(matrix));
    }
}

class Solution54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        int x = 0, y = 0;
        int dirIndex = 0;
        int[] curDir = directions[dirIndex % 4];
        int count = 0;

        while (count < rows * columns) {
            result.add(matrix[x][y]);
            visited[x][y] = 1;
            count++;
            x = x + curDir[0];
            y = y + curDir[1];
            if (x == rows || x == -1 || y == columns || y == -1 || visited[x][y] == 1) {
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