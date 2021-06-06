import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40 {
    public static void main(String[] args) {
        Solution40_1 s = new Solution40_1();
        int[] candidates = {2,5,2,1,2};
        s.combinationSum2(candidates,5);
    }
}

// 特别注意避免重复的31行，精髓
class Solution40_1 {
    List<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, target);
        return res;
    }

    public void backtracking(int[] candidates, int index, int sum, int target) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            sum = sum + candidates[i];
            backtracking(candidates, i + 1, sum, target);
            sum = sum - candidates[i];
            path.remove(path.size() - 1);
        }
    }
}

/*
解释语句: if (cur > begin && candidates[cur-1] == candidates[cur]) 是如何避免重复的。
(for循环是横向，add + backtracking是纵向)

这个避免重复当思想是在是太重要了。
这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
                  1
                 / \
                2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
               /     \
              5       5
                例2
                  1
                 /
                2      这种情况确是允许的
               /
              2

为何会有这种神奇的效果呢？
首先 cur-1 == cur 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。
因为当第二个2出现的时候，他就和前一个2相同了。

那么如何保留例2呢？
那么就用cur > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
例2的两个2是处在不同层级上的。
在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
第一个出现的2的特点就是 cur == begin. 第二个出现的2 特点是cur > begin.
 */