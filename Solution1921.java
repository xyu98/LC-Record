import java.util.Arrays;

public class Solution1921 {
    public static void main(String[] args) {
        int[] dist = {3,5,7,4,5};
        int[] speed = {2,3,6,3,2};
        Solution1921_1 s = new Solution1921_1();
        System.out.println(s.eliminateMaximum(dist, speed));
    }
}

class Solution1921_1 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] times = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            times[i] = Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(times);
        for (int i = 1; i < dist.length; i++) {
            if (times[i] <= i) return i;
        }
        return dist.length;
    }
}