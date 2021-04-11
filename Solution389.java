import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Solution389 {
    public static void main(String[] args) {
        Solution389_3 s = new Solution389_3();
        String s1 = "abcdee";
        String s2 = "eebbacd";
        System.out.println(s.findTheDifference(s1,s2));
    }
}

// 解1：时间 21 ms（超过5.17%），内存 37.9 MB（超过6.19%） 时间O(N(N+1))，空间O(N)
class Solution389_1 {
    public char findTheDifference(String s, String t) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            list.add(t.charAt(i));
        }
        int i = 0;
        while (i < s.length() && list.contains(s.charAt(i))) {
            Character c = s.charAt(i);
            list.remove(c);
            i++;
        }
        return list.get(0);
    }
}

// 解2：时间 2 ms（超过80.18%），内存 36.6 MB（超过93.41%） 时间O(N)，空间O(1)  完美
// 把char类型当作整数加起来，算两个字符串的差
class Solution389_2 {
    public char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }
}

// 解3：时间O(N)，空间O(1) 利用异或（比较难想）
class Solution389_3 {
    public char findTheDifference(String s, String t) {
        char res = 0;
        // toCharArray将字符串转化为字符数组，因为字符串无法用foreach
        // 把s和t看成一个数组，则大数组中只有一个元素不是成对的，就是多出的那个元素
        // 因此将两个数组中所有的元素全部异或，得到的就是结果
        for (char c: s.toCharArray()) {
            res ^= c;
        }
        for (char c: t.toCharArray()) {
            res ^= c;
        }
        return res;
    }
}