package tree;

public class TestClass {

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<Integer, String>();
        boolean showRecursiveAlgorithm = true;
        
        if (showRecursiveAlgorithm) {
            bst.addNodeRecursive(25,"25");
            bst.addNodeRecursive(12,"12");
            bst.addNodeRecursive(13,"13");
            bst.addNodeRecursive(14,"14");
            bst.addNodeRecursive(36,"36");
            bst.addNodeRecursive(7,"7");
            bst.addNodeRecursive(30,"30");
            bst.addNodeRecursive(10,"10");
            bst.addNodeRecursive(39,"39");
            bst.addNodeRecursive(37,"37");
            bst.addNodeRecursive(38,"38");
            bst.addNodeRecursive(44,"44");
            bst.addNodeRecursive(3,"3");
            bst.addNodeRecursive(8,"8");

            System.out.println("Tree with 14 nodes: ");
            bst.view();

            bst.deleteNodeRecursive(12);
            bst.deleteNodeRecursive(37);
            bst.deleteNodeRecursive(25);
            bst.deleteNodeRecursive(44);

            System.out.println("\nTree after 4 deletions: ");
            bst.view();

            bst.deleteNodeRecursive(13);
            bst.deleteNodeRecursive(14);
            bst.deleteNodeRecursive(10);
            bst.deleteNodeRecursive(3);
            bst.deleteNodeRecursive(7);
            bst.deleteNodeRecursive(8);
            bst.deleteNodeRecursive(36);
            bst.deleteNodeRecursive(39);
            bst.deleteNodeRecursive(30);
            bst.deleteNodeRecursive(38);

            System.out.println("\nEmpty tree: ");
            bst.view();

            bst.deleteNodeRecursive(25);
            bst.deleteNodeRecursive(44);

            System.out.println("\nEven deleting non-existing node does not cause error!");
        } else {
            bst.addNode(25,"25");
            bst.addNode(12,"12");
            bst.addNode(13,"13");
            bst.addNode(14,"14");
            bst.addNode(36,"36");
            bst.addNode(7,"7");
            bst.addNode(30,"30");
            bst.addNode(10,"10");
            bst.addNode(39,"39");
            bst.addNode(37,"37");
            bst.addNode(38,"38");
            bst.addNode(44,"44");
            bst.addNode(3,"3");
            bst.addNode(8,"8");

            bst.view();

            bst.deleteNode(12);
            bst.deleteNode(37);
            bst.deleteNode(25);
            bst.deleteNode(44);
        }

        System.out.println();
        bst.view();

    }

}
