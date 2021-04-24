public class Solution14 {
    public static void main(String[] args) {
        Solution14_1 s = new Solution14_1();
        String[] strs = {"abab","aba",""};
        String[] strs1 = {"aaaa"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}

// 解1：时间 O(N^2) 空间O(N) 空间复杂度较高，可以不使用额外的数组，只要记录一个位置index就可以
// 时间 1ms (84.42%) 空间 36.6MB (48.55%)
class Solution14_1 {
    public String longestCommonPrefix(String[] strs) {
        boolean flag = true;
        int[] sum = new int[strs.length];
        StringBuilder res = new StringBuilder();
        if (strs.length == 0 || strs.length == 1) return strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) return res.toString();
            sum[i] = strs[i].charAt(0);
        }
        int j = 1;
        while (flag) {
            for (int i = 0; i < strs.length; i++) {
                if (i + 1 < strs.length && sum[i] != sum[i + 1]) return res.toString();
                if (j < strs[i].length()) {
                    sum[i] = sum[i] + strs[i].charAt(j);
                }
                else flag = false;
            }
            res.append(strs[0].charAt(j - 1));
            j++;
        }
        return res.toString();
    }
}