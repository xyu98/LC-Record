public class Solution135 {
}

class Solution135_1 {
    public int candy(int[] ratings) {
        int[] candyNum = new int[ratings.length];
        candyNum[0] = 1;
        // 从前向后
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candyNum[i] = candyNum[i - 1] + 1;
            else candyNum[i] = 1;
        }
        // 从后往前
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candyNum[i] <= candyNum[i + 1]) {
                candyNum[i] = candyNum[i + 1] + 1;
            }
        }
        int res = 0;
        for (int i: candyNum) {
            res += i;
        }
        return res;
    }
}