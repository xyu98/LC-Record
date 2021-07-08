import java.util.Arrays;
import java.util.HashMap;

public class Solution242 {
    public static void main(String[] args) {
        Solution242_1 so = new Solution242_1();
        String s = "aacc";
        String t = "ccac";
        System.out.println(so.isAnagram(s,t));
    }
}

class Solution242_1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> times = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            times.put(s.charAt(i), 0);
        }
        for (int i = 0; i < s.length(); i++) {
            times.put(s.charAt(i), times.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!times.containsKey(t.charAt(i))) return false;
            times.put(t.charAt(i), times.get(t.charAt(i)) - 1);
        }
        for (Integer value : times.values()) {
            if (value != 0) return false;
        }
        return true;
    }
}

// 原理相同，只不过换成了数组
class Solution242_2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] times = new int[26];
        int i;
        for (i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < t.length(); i++) {
            times[t.charAt(i) - 'a']--;
        }
        for (int time : times) {
            if (time != 0) return false;
        }
        return true;
    }
}

// 另一种解法，时间复杂度相同O(N)，空间复杂度较高O(N)，而上面的方法是O(1)
class Solution242_3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}