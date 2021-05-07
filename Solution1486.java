public class Solution1486 {
    public static void main(String[] args) {
        int n = 2;
        int start = 5;
        Solution1486_1 s = new Solution1486_1();
        System.out.println(s.xorOperation(n, start));
    }
}

class Solution1486_1 {
    public int xorOperation(int n, int start) {
        int res = start;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start + i * 2;
            if (i != 0) {
                res = arr[i] ^ res;
            }
        }
        return res;
    }
}

// 优化版，不使用额外的内存空间
class Solution1486_2 {
    public int xorOperation(int n, int start) {
        int ans = start;
        while (n > 1) {
            start += 2;
            ans ^= start;
            n--;
        }
        return ans;
    }
}