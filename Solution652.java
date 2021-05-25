import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution652 {
}

class Solution652_1 {
    HashMap<String, Integer> treeInfo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);

        // 这里需要记录的是每个节点对应的子树，包括左右子树和自己
        String subTree = left + "," + right+ "," + root.val;

        // 作用：如果Map中不存在subTree则加入Map，并赋值defaultValue（0，也就是出现的次数）
        // 如果Map中已经存在subTree，则获取其value
        int freq = treeInfo.getOrDefault(subTree, 0);
        // 多次重复也只会被加入结果集一次
        if (freq == 1) {
            res.add(root); // 若value = 1，则说明至少出现过两次，添加到结果中
        }
        // 给子树对应的出现次数加一
        treeInfo.put(subTree, freq + 1);
        return subTree;
    }
}
