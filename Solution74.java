public class Solution74 {
    public static void main(String[] args) {
        Solution74_1 s = new Solution74_1();
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1}};
        // matrix.length是行数，matrix[0].length是列数
        System.out.println(s.searchMatrix(matrix, 1));
    }
}

// 解1：先二分查找行，再二分查找列
// 时间O(N)空间O(1) 100% 80.61%
class Solution74_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0, high = matrix.length - 1;
        int mid = (low + high) / 2;
        int rank = 0, col = 0;
        while (low <= high) {
            if (matrix[mid][0] == target) return true;
            else if (matrix[mid][0] < target) low = mid + 1;
            else high = mid - 1;
            mid = (low + high) / 2;
        }
        if (matrix[mid][0] > target) rank = Math.max(mid - 1, 0);
        else rank = mid;
        low = 0;
        high = matrix[0].length - 1;
        mid = (low + high) / 2;
        while (low <= high) {
            if (matrix[rank][mid] == target) return true;
            else if (matrix[rank][mid] < target) low = mid + 1;
            else high = mid - 1;
            mid = (low + high) / 2;
        }
        return false;
    }
}