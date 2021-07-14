public class Solution28 {
    public static void main(String[] args) {
        Solution28_1 s = new Solution28_1();
        System.out.println(s.strStr("aabacaabaaf", "aabaaf"));
    }
}

class Solution28_1 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int[] next = getNext(needle);  // next数组含义：最长相等前后缀
        int j = 0; // needle数组指针
        // i是haystack数组指针，遍历haystack数组
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i)) j++;
            if (j == needle.length()) return i - needle.length() + 1;
        }
        return -1;
    }

    public int[] getNext(String needle) {
        int j = 0; // j既充当前缀的指针，又充当计数器。i负责遍历整个needle数组
        int[] next = new int[needle.length()];
        for (int i = 1; i < needle.length(); i++) {
            // 不相等，j指针跳到前一个位置。（next数组存放的是下标，也就是不匹配时要跳到哪个位置）
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) j = next[j - 1];
            if (needle.charAt(i) == needle.charAt(j)) j++;
            next[i] = j;
        }
        return next;
    }
}