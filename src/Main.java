public class Main {

    public static void main(String[] args) {
        IntegerBinarySearchTree tree = new IntegerBinarySearchTree();
        tree.addTreeNode(50);
        tree.addTreeNode(12);
        tree.addTreeNode(42);
        tree.addTreeNode(49);
        tree.addTreeNode(38);
        tree.addTreeNode(81);
        tree.addTreeNode(6);
        tree.addTreeNode(62);
        tree.addTreeNode(75);
        tree.addTreeNode(99);


        System.out.println("Nút gốc: "+tree.getRoot().getValue());
        System.out.println("Chiều cao cây: "+tree.getHeight());
        System.out.println("Kích thước của cây: "+tree.size() + " nút");

        tree.printPostOrder();

    }
}
