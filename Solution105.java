// build a tree through pre-order and in-order arrays.
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) return null;

        int rootValue = preorder[preStart];  //注意这里下标不能是0
        //寻找root.value在inorder中的位置，利用inorder划分左右子树的范围
        int rootPos;
        for (rootPos = inStart; rootPos < inorder.length; rootPos++) {
            if (inorder[rootPos] == rootValue) break;
        }
        int leftSize = rootPos - inStart;
        TreeNode root = new TreeNode(rootValue);

        root.left = build(preorder, preStart + 1, preStart + leftSize, //注意+1
                inorder, inStart, rootPos - 1); //除去根节点，故preorder的指针从preStart + 1开始
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootPos + 1, inEnd);
        return root;
    }
}