public class Solution116 {
}

class Solution116_1 {
    public Node connect(Node root) {
        if (root == null) return root;
        connectNode(root.left, root.right);
        return root;
    }

    // 解不出来，思路不对
    /*public void connectNode(Node node1, Node node2) {
        if (node1 == null && node2 == null) return;
        node1.next = node2;
        if (node1.left != null && node2.left != null) {
            node1.left.next = node1.right;
            node1.right.next = node2.left;
            node2.left.next = node2.right;
        }
        connectNode(node1.left, node1.right);
        connectNode(node2.left, node2.right);
    }*/

    public void connectNode(Node node1, Node node2) {
        if (node1 == null && node2 == null) return;
        node1.next = node2;
        connectNode(node1.left, node1.right);
        connectNode(node2.left, node2.right);
        //最关键的一步
        connectNode(node1.right, node2.left);
    }
}