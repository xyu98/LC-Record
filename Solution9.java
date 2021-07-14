import java.util.ArrayList;

public class Solution9 {
    public static void main(String[] args) {
        Solution9_1 s = new Solution9_1();
        System.out.println(s.isPalindrome(123454321));
    }
}

class Solution9_1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int[] arr = new int[10];
        int index = 0, cur;
        while (x > 0) {
            cur = x % 10;
            arr[index++] = cur;
            x /= 10;
        }
        for (int i = 0, j = index - 1; i < j; i++, j--) {
            if (arr[i] != arr[j]) return false;
        }
        return true;
    }
}