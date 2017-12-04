/**
 * Created by francesco.rossato on 27/11/2017.
 */
public class Node<T> {
    private Node next;
    private Node previous;
    private T info;

    public Node(Node next, Node previous, T info) {
        this.next = next;
        this.previous = previous;
        this.info = info;
    }
    public Node(T info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }
    public Node getPrevious() {
        return previous;
    }
    public T getInfo() {
        return info;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    public void setInfo(T info) {
        this.info = info;
    }
}
