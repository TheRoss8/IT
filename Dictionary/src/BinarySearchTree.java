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
        if(this.info == null)
            this.info = info;
        else {
            if (info.compareTo(this.info) > 0) {
                if (this.right == null) right = new BinarySearchTree(info);
                else right.add(info);
            } else {
                if (this.left == null) left = new BinarySearchTree(info);
                else left.add(info);
            }
        }
    }

    public static void inOrderTraversal(BinarySearchTree tree){
        if(tree != null){
            inOrderTraversal(tree.getLeft());
            System.out.println(tree.info);
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
    public static BinarySearchTree search(Comparable info, BinarySearchTree binarySearchTree){
        if(binarySearchTree.info.compareTo(info) == 0)
            return binarySearchTree;
        if(binarySearchTree.info.compareTo(info) < 0)
            if(binarySearchTree.getRight() != null)
                return search(info, binarySearchTree.getRight());
        if(binarySearchTree.getLeft() != null)
            return search(info, binarySearchTree.getLeft());
        return null;
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
