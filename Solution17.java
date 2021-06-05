import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution17 {
    public static void main(String[] args) {
        Solution17_1 s = new Solution17_1();
        s.letterCombinations("23");
    }
}

class Solution17_1 {
    List<String> res = new LinkedList<>();
    StringBuilder path = new StringBuilder();
    String[] strMap = new String[]
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtracking(0, digits);
        return res;
    }

    public void backtracking(int index, String digits) {
        if (index == digits.length()) {
            res.add(new String(path));
            return;
        }
        for (int i = 0; i < strMap[Character.getNumericValue(digits.charAt(index))].length(); i++) {
            path.append(strMap[Character.getNumericValue(digits.charAt(index))].charAt(i));
            backtracking(index + 1, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}