import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    public static void main(String[] args) {
        Solution56_1 s = new Solution56_1();
        int[][] intervals = {{1,4},{0,2},{3,5}};
        s.merge(intervals);
    }
}

class Solution56_1 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        if (intervals.length == 1) return intervals;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i;
        for (i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {
                intervals[i][1] = Math.max(intervals[i - 1][1], intervals[i][1]);
                intervals[i][0] = Math.min(intervals[i - 1][0], intervals[i][0]);
            }
            else  {
                res.add(new int[]{intervals[i - 1][0], intervals[i - 1][1]});
            }
        }
        res.add(new int[]{intervals[i - 1][0], intervals[i - 1][1]});
        int[][] resMatrix = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            resMatrix[j] = res.get(j);
        }
        return resMatrix;
    }
}