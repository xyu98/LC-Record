public class Solution342 {
    public static void main(String[] args) {
        Solution342_1 s = new Solution342_1();
        System.out.println(s.isPowerOfFour(5));
    }
}

class Solution342_1 {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        if (n != 1 && n % 4 != 0) return false;
        if (n == 1) return true;
        return isPowerOfFour(n / 4);
    }
}