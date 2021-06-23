import java.util.ArrayList;
import java.util.List;

public class Solution139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        Solution139_1 so = new Solution139_1();
        System.out.println(so.wordBreak(s, list));
    }
}

// 把背包中的物品也看成单个字符，而非一个个单词
class Solution139_1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) { // 遍历背包
            for (int i = 0; i < j; i++) {       // 遍历物品
                String word = s.substring(i, j);
                if (dp[i] && wordDict.contains(word)) {
                    dp[j] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}