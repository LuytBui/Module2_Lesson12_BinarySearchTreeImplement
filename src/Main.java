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


        System.out.println("Nút gốc: " + tree.getRoot().getValue());
        System.out.println("Chiều cao cây: " + tree.getHeight());
        System.out.println("Kích thước của cây: " + tree.size() + " nút");

        tree.printPreOrder();
        tree.printPostOrder();

        int value = 49;
        System.out.println("Đường dẫn tới nút " + value + " là: " + tree.pathTo(value));

        value = 62;
        System.out.println("Đường dẫn tới nút " + value + " là: " + tree.pathTo(value));

        System.out.println();
        value = 10;
        System.out.println("Cây chứa phần tử "+ value + ": "+ tree.contains(value));
        value = 99;
        System.out.println("Cây chứa phần tử "+ value + ": "+ tree.contains(value));


        System.out.println();
        value = 62;
        System.out.println("Xóa phần tử " + value + ": "+ tree.remove(value));
        System.out.println("Đường dẫn tới nút " + value + " là: " + tree.pathTo(value));
        System.out.println("Kích thước mới của cây: " + tree.size() + " nút");
        tree.printPostOrder();

        System.out.println();
        value = 55; // không có trong cây
        System.out.println("Xóa phần tử " + value + ": "+ tree.remove(value));
    }
}
