import java.util.HashSet;

public class Solution202 {
}

class Solution202_1 {
    public boolean isHappy(int n) {
        HashSet<Integer> sums = new HashSet<>();
        int sum = calSum(n);
        while (sum != 1) {
            if (!sums.add(sum)) return false;
            sum = calSum(sum);
        }
        return true;
    }

    public int calSum(int n) {
        int sum = 0, temp, singleNum;
        while (n != 0) {
            temp = n / 10;
            singleNum = n - temp * 10;
            sum = sum + singleNum * singleNum;
            n = temp;
        }
        return sum;
    }
}

/*
    // 取数值各个位上的单数之和
    public int getSum(int n) {
        int sum = 0;
        while (n) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }*/
