import java.util.LinkedList;
import java.util.List;

public class Solution131 {
    public static void main(String[] args) {
        Solution131_1 s = new Solution131_1();
        String str = "cbbbcc";
        s.partition(str);
    }
}

// 解1：暴力回溯搜索
class Solution131_1 {
    List<String> path = new LinkedList<>();
    List<List<String>> res = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return res;
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s.substring(startIndex,i + 1))) {
                path.add(s.substring(startIndex,i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}

// 解2：回溯+记忆（剪枝）
class Solution131_2 {
    List<String> path = new LinkedList<>();
    List<List<String>> res = new LinkedList<>();
    int[][] f;

    public List<List<String>> partition(String s) {
        if (s.isEmpty()) return res;
        int n = s.length();
        f = new int[n][n];
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i) == 1) {  // 这一步判断的作用是避免重复搜索
                path.add(s.substring(startIndex,i + 1));
                backtracking(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    // 记忆化搜索，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;  // 表示一直递归到最后了，是回文串
        } else if (s.charAt(i) == s.charAt(j)) {  // 还没递归完
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {  // 不是回文串
            f[i][j] = -1;
        } // 其他情况都是还没搜索到
        return f[i][j];
    }
}