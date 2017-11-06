import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by francesco.rossato on 03/11/2017.
 */
public class BinarySearchTree{
    private BinarySearchTree right;
    private BinarySearchTree left;
    private Comparable info;

    public BinarySearchTree(BinarySearchTree right, BinarySearchTree left, Comparable info) {
        this.right = right;
        this.left = left;
        this.info = info;
    }
    public BinarySearchTree(Comparable info){
        this(null, null, info);
    }
    public BinarySearchTree(){

    }

    public void add(Comparable info){
        if(info.compareTo(this.info) > 0) {
            if (this.right == null) right = new BinarySearchTree(info);
            else right.add(info);
        }
        else{
            if(this.left == null) left = new BinarySearchTree(info);
            else left.add(info);
        }
    }
    public static Object[] inOrderTraversal(BinarySearchTree tree){
        ArrayList<Comparable> out = new ArrayList();
        inOrderTraversal(tree, out);
        return out.toArray();
    }

    public static void inOrderTraversal(BinarySearchTree tree, ArrayList<Comparable> out){
        if(tree != null){
            inOrderTraversal(tree.getLeft());
            out.add(tree.info);
            inOrderTraversal(tree.getRight());
        }
    }

    public BinarySearchTree getRight() {
        return right;
    }
    public BinarySearchTree getLeft() {
        return left;
    }
    public Comparable getInfo() {
        return info;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }
    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }
    public void setInfo(Comparable info) {
        this.info = info;
    }
}
