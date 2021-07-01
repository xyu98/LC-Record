import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution107 {
}

class Solution107_1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = q.peek();
                list.add(node.val);
                q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(list);
        }

        Collections.reverse(res);
        return res;
    }
}