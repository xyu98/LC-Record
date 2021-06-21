public class Solution1049 {
    public static void main(String[] args) {

    }
}

// dp[]方括号内代表的含义还是不熟
class Solution1049_1 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone: stones) {
            sum += stone;
        }
        int target = sum / 2;
        int[] dp = new int[15000];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] * 2;
    }
}