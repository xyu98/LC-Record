public class Solution151 {
}

class Solution151_1 {
    public String reverseWords(String s) {
        if (s.length() == 1) return s;
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
            while (j >= 0 && s.charAt(j) != ' ') j--;
            res.append(s, j + 1, i + 1);
            res.append(' ');
            i = j - 1;
        }
        int k;
        for (k = res.length() - 1; k >= 0; k--) {
            if (res.charAt(k) != ' ') break;
        }
        return res.substring(0, k + 1);
    }
}