public class Solution134 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Solution134_1 s = new Solution134_1();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}

class Solution134_1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, curSum = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            rest = gas[i] - cost[i];
            curSum += rest;
            min = Math.min(min, curSum);
        }
        if (curSum < 0) return -1;  // gas总和小于cost总和
        if (min >= 0) return 0;  // 从0开始，每一步都够用，返回0即可
        // 如果累加的最⼩值是负数，汽⻋就要从⾮0节点出发，从后向前，看哪个节点能这个负数填平
        // 能把这个负数填平的节点就是出发节点
        // 注意一定要从后往前！！有逻辑
        for (int i = gas.length - 1; i >= 0; i--) {
            rest = gas[i] - cost[i];
            min += rest;
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }
}