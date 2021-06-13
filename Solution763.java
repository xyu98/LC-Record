import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        Solution763_1 s = new Solution763_1();
        s.partitionLabels(str);
    }
}

class Solution763_1 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] furthest = new int[26];
        // 遍历一遍，统计每个字母最后出现的次数
        for (int i = 0; i < s.length(); i++) {
            furthest[s.charAt(i) - 'a'] = i;
        }
        // 开始分割
        int boundaryStart = 0, boundaryEnd = 0;
        for (int i = 0; i < s.length() && boundaryStart < s.length(); i++) {
            boundaryEnd = Math.max(boundaryEnd, furthest[s.charAt(i) - 'a']);
            if (i == boundaryEnd) {
                res.add(boundaryEnd - boundaryStart + 1);
                boundaryStart = boundaryEnd + 1;
            }
        }
        return res;
    }
}