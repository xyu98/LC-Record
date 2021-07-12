public class Solution344 {
    public static void main(String[] args) {
        Solution344_1 s = new Solution344_1();
        char[] string = {'a','b','c','f','t'};
        s.reverseString(string);
        System.out.println(string);
    }
}

// 要求：O(1)的额外空间


class Solution344_1 {
    public void reverseString(char[] s) {
        if (s == null || s.length == 1) return;
        int left = 0, right = s.length - 1;
        char temp;
        while (right > left) {
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}

// 解2：递归，双指针的递归，每一对头尾指针作为一层，从数组的外面往里递，从里往外归（洋葱）
class Solution344_2 {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

    }
}