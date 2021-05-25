// build a tree through post-order and in-order arrays.
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) return null;

        int rootValue = postorder[postEnd]; ////注意这里下标不能是length-1
        //寻找rootValue在inorder中的位置
        int rootPos;
        for (rootPos = inStart; rootPos < inorder.length; rootPos++) {
            if (inorder[rootPos] == rootValue) break;
        }
        int leftSize = rootPos - inStart;
        TreeNode root = new TreeNode(rootValue);

        root.left = build(inorder, inStart, rootPos - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, rootPos + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1); //注意这里要减1，除去根节点
        return root;
    }
}