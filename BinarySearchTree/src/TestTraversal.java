/**
 * Created by francesco.rossato on 03/11/2017.
 */
public class TestTraversal {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(43);
        bst.add(34);
        bst.add(56);
        bst.add(1024);
        BinarySearchTree.inOrderTraversal(bst);
    }
}
