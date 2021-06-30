public class Solution168 {
    public static void main(String[] args) {
        Solution168_1 s = new Solution168_1();
        System.out.println(s.convertToTitle(2147483647));
    }
}

// 就是十进制转26进制
class Solution168_1 {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char) (n % 26 + 'A'));
            n = n / 26;
        }
        return result.reverse().toString();
    }
}