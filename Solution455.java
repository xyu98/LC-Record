import java.util.Arrays;

public class Solution455 {
    public static void main(String[] args) {
        Solution455_1 solu = new Solution455_1();
        int[] g = {1,2,3};
        int[] s = {1,1};
        solu.findContentChildren(g,s);
    }
}

// 解1：1个循环遍历两个数组
class Solution455_1 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // child
        Arrays.sort(s); // cookie size
        int res = 0, index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                res++;
                index--;
            }
        }
        return res;
    }
}