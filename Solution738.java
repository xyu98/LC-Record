import java.util.Arrays;

public class Solution738 {
    public static void main(String[] args) {
        Solution738_1 s = new Solution738_1();
        System.out.println(s.monotoneIncreasingDigits(120));
    }
}

class Solution738_1 {
    public int monotoneIncreasingDigits(int n) {
        if (n <= 10) return n - 1;
        boolean flag;
        char[] strNum = Integer.toString(n).toCharArray();
        for (int i = strNum.length - 1; i >= 1; i--) {
            flag = false;
            if (strNum[i] < strNum[i - 1]) {
                flag = true;
            }
            if (flag) {
                for (int j = strNum.length - 1; j >= i; j--) {
                    strNum[j] = '9';
                }
                strNum[i - 1]--;
            }
        }
        return Integer.parseInt(String.valueOf(strNum));
    }
}