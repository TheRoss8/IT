/**
 * Created by francesco.rossato on 24/11/2017.
 */
public class BinaryTree{
    private BinaryTree right;
    private BinaryTree left;
    private String info;

    public BinaryTree getRight() {
        return right;
    }
    public BinaryTree getLeft() {
        return left;
    }
    public String getInfo() {
        return info;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }
    public void setLeft(BinaryTree left) {
        this.left = left;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public boolean isOperand(){
        return info == "+" || info == "-" || info == "*" || info == "/";
    }

    public static void inOrderTraversal(BinarySearchTree tree){
        if(tree != null){
            inOrderTraversal(tree.getLeft());
            System.out.println(tree.getInfo());
            inOrderTraversal(tree.getRight());
        }
    }
}
