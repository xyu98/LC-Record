public class Solution509 {
    public static void main(String[] args) {
        Solution509_1 s = new Solution509_1();
        System.out.println(s.fib(6));
    }
}

class Solution509_1 {
    public int fib(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;
        return fib(n - 1) + fib(n - 2);
    }
}

class Solution509_2 {
    public int fib(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        int pre = 1, cur = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return sum;
    }
}