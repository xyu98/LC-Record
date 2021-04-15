import java.util.Arrays;

public class Solution881 {
    public static void main(String[] args) {
        Solution881_1 s = new Solution881_1();
        int[] people = {3,5,3,4}; // 每个人的体重
        int limit = 5; // 每艘船最多可载两人
        System.out.println(s.numRescueBoats(people,limit));
    }
}

// 解1：时间O(N),空间O(1)
// 双指针对撞
class Solution881_1 {
    public int numRescueBoats(int[] people, int limit) {
        int cnt = 0;
        boolean flag = true;
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        while (i <= j){
            flag = true;
            if (i == j) {
                cnt += 1;
                break;
            }
            if (people[j] + people[i] <= limit) {
                cnt += 1;
                i++;
                j--;
            }
            else {
                cnt += 1;
                j--;
                flag = false;
            }
        }
        if (flag) return cnt;
        else return cnt + 1;
    }
}