import java.util.Arrays;
import java.util.Comparator;

public class Solution452 {
    public static void main(String[] args) {
        Solution452_2 s = new Solution452_2();
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(s.findMinArrowShots(points));
    }
}

// 解2：利用覆盖范围
class Solution452_2 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]) ;
                else return Integer.compare(o1[1], o2[1]) ;
            }
        });
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) res++;
            else points[i][1] = Math.min(points[i][1], points[i - 1][1]); // 右边界要选最小的
        }
        return res;
    }
}

// 解1：没写出来，思路不对
class Solution452_1 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]) ;
                else return Integer.compare(o1[1], o2[1]) ;
            }
        });
        int res = 1;
        int i = 0, j = 0;
        while (i < points.length - 1) {
            int terminal = points[i][1];
            int start = points[i][0];
            for (j = i + 1; j < points.length; j++) {
                if ((points[j][0] <= terminal && points[j][1] >= terminal)
                        || (points[j][1] <= terminal))continue;
                res++;
                break;
            }
            i = j;
        }
        return res;
    }
}