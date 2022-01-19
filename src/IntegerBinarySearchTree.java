import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    public TreeNode getRoot(){
        return this.root;
    }
    public int size(){
        Stack<TreeNode> stack = new Stack<>();
        int size = 0;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode current = stack.pop();
            size ++;

            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return size;
    }

    public void addTreeNode(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            addTreeNode(root, value);
        }
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
        System.out.print("Các nút theo tiền thứ tự: ");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.value + " ");
        printPreOrder(treeNode.left);
        printPreOrder(treeNode.right);
    }

    public void printPostOrder(){
        System.out.print("Các nút theo hậu thứ tự: ");
        printPostOrder(root);
        System.out.println();
    }
    private void printPostOrder(TreeNode treeNode){
        if (treeNode == null) return;
        if (treeNode.left != null) {
            printPostOrder(treeNode.left);
        }
        if (treeNode.right != null) {
            printPostOrder(treeNode.right);
        }
        System.out.print(treeNode.value+ " ");
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        return (1 + Math.max(getHeight(node.left), getHeight(node.right)));
    }

    public List<Integer> pathTo(int value){
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

    public boolean remove(int value){
        if (root.value == value){
            root = null;
            return true;
        }

        return remove(root, value);
    }

    public boolean remove(TreeNode node, int value){
        if (node == null)
            return false;

        if(node.left != null && node.left.value == value){
            node.left = null;
            return true;
        }

        if(node.right != null && node.right.value == value){
            node.right = null;
            return true;
        }

        if (node.value > value){
            return remove(node.left, value);
        } else {
            return remove(node.right, value);
        }
    }

    public boolean contains(int value){
        boolean isFound = false;
        TreeNode node = root;
        while(node != null){
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
        return isFound;
    }



}
