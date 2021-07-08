import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution349 {
}

class Solution349_1 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> judge = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            judge.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (judge.contains(nums2[i])) result.add(nums2[i]);
        }
        int[] res = new int[result.size()];
        Integer[] temps = result.toArray(new Integer[] {});
        for (int i = 0; i < result.size(); i++) {
            res[i] = temps[i];
        }
        return res;
    }
}