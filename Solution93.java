import java.util.LinkedList;
import java.util.List;

public class Solution93 {
    public static void main(String[] args) {
        Solution93_1 s = new Solution93_1();
        String str = "1111";
        s.restoreIpAddresses(str);
    }
}

class Solution93_1 {
    String path = new String();
    List<String> res = new LinkedList<>();
    int num = 0;

    public List<String> restoreIpAddresses(String s) {
        if (s.isEmpty()) return res;
        backtracking(s, 0);
        return res;
    }

    public void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) return;
        if (num == 3) {
            if (isIpPart(s.substring(startIndex))) {
                path = path + s.substring(startIndex);
                num++;
                res.add(new String(path));
                // 特别注意，只要有添加就必须撤销！！！
                path = path.substring(0, path.length() - s.substring(startIndex).length());
                num--;
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (isIpPart(str) && i + 1 < s.length()) {
                path = path + str + ".";
                num++;
                backtracking(s, i + 1);
                num--;
                path = path.substring(0, path.length() - str.length() - 1);
            }
            else break;
        }
    }

    public boolean isIpPart(String str) {
        if (str.length() > 3 || str.length() < 1) return false;
        if (str.length() != 1 && str.charAt(0) == '0') return false;
        return Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255;
    }
}