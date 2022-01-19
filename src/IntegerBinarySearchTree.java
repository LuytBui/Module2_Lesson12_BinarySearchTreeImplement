import java.util.ArrayList;
import java.util.LinkedList;

public class IntegerBinarySearchTree {
    public class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
        public int getValue(){
            return value;
        }

        public TreeNode() {
        }

        public TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root = null;
    private int size = 0;

    public TreeNode getRoot(){
        return this.root;
    }
    public int size(){
        return this.size;
    }

    public void addTreeNode(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            addTreeNode(root, value);
        }
        size++;
    }

    private void addTreeNode(TreeNode node, int value) {
        if (node.value > value) {
            if (node.left == null) {
                node.left = new TreeNode(value);
            } else {
                addTreeNode(node.left, value);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(value);
            } else {
                addTreeNode(node.right, value);
            }
        }
    }

    public void printPreOrder() {
        System.out.println("Các nút theo tiền thứ tự: ");
        printPreOrder(root);
    }

    private void printPreOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println(treeNode.value);
        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    public void printPostOrder(){
        System.out.println("Các nút theo hậu thứ tự: ");
        printPostOrder(root);
    }
    private void printPostOrder(TreeNode treeNode){
        if (treeNode == null) return;
        if (treeNode.left != null) {
            printPostOrder(treeNode.left);
        }
        if (treeNode.right != null) {
            printPostOrder(treeNode.right);
        }
        System.out.println(treeNode.value);
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return (1 + Math.max(getHeight(node.left), getHeight(node.right)));
    }

    public LinkedList<Integer> pathTo(int value){
        LinkedList<Integer> path = new LinkedList<>();
        TreeNode node = root;
        boolean isFound = false;
        while(node != null){
            path.add(node.value);
            if (node.value == value){
                isFound = true;
                break;
            }
            if (node.value > value){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return isFound? path : null;
    }


}
