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