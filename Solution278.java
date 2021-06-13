public class Solution278 {
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class VersionControl {
    public boolean isBadVersion(int n) {
        return true;
    }
}


class Solution278_1 extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        int start = 1, end = n;
        int mid;
        while (start < end) {
            // mid = (start + end) / 2; // 存在溢出风险
            mid = start + (end - start) / 2;
            if (isBadVersion(mid)) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}