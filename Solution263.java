public class Solution263 {
    public static void main(String[] args) {
        Solution263_2 s = new Solution263_2();
        System.out.println(s.isUgly(0));
    }
}

// 第1次提交：执行用时: 1 ms（超过100%），内存消耗: 35.6 MB MB（超过29.12%）——空间复杂度高
class Solution263_1 {
    public boolean isUgly(int n) {
        boolean flag = false;
        if (n == 1) {
            flag = true;
        }
        else if (n % 2 == 0 && n != 0) {
            n = n / 2;
            return isUgly(n);
        }
        else if (n % 3 == 0 && n != 0) {
            n = n / 3;
            return isUgly(n);
        }
        else if (n % 5 == 0 && n != 0) {
            n = n / 5;
            return isUgly(n);
        }
        return flag;
    }
}

// 第2次提交：执行用时: 1 ms（超过100%），内存消耗: 35.3 MB MB（超过86.31%）——时间复杂度和解法一相同，空间复杂度降低了
class Solution263_2 {
    public boolean isUgly(int n) {
        if (n < 1) return false;
        while (n % 5 == 0){
            n /= 5;
        }
        while (n % 3 == 0){
            n /= 3;
        }
        while (n % 2 == 0){
            n >>= 1; // 除以2用移位代替
        }
        return n == 1;
    }
}

// 第3次提交：执行用时: 1 ms（超过100%），内存消耗: 35.2 MB MB（超过97.66%）——完美
// 和解法一的思路完全相同
class Solution263_3 {
    public boolean isUgly(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 2 == 0) return isUgly(n / 2);
        if (n % 3 == 0) return isUgly(n / 3);
        if (n % 5 == 0) return isUgly(n / 5);
        return false;
    }
}