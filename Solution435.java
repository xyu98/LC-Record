import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        Solution435_1 s = new Solution435_1();
        System.out.println(s.eraseOverlapIntervals(intervals));
    }
}

class Solution435_1 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= intervals[i - 1][1]) {
                res++;
                continue;
            }
            if (intervals[i][0] < intervals[i - 1][1]) {
                res++;
                intervals[i][1] = intervals[i - 1][1];
            }
        }
        return res;
    }
}