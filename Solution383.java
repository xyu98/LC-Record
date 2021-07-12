import java.util.HashMap;

public class Solution383 {
}

// 用哈希表（同样的原理也可以用数组实现）
class Solution383_1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        char magz, rans;
        for (int i = 0; i < magazine.length(); i++) {
            magz = magazine.charAt(i);
            if (map.containsKey(magz)) map.put(magz, map.get(magz) + 1);
            else map.put(magz, 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            rans = ransomNote.charAt(i);
            if (!map.containsKey(rans)) return false;
            else if (map.get(rans) < 1) return false;
            else map.put(rans, map.get(rans) - 1);
        }
        return true;
    }
}