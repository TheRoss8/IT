/**
 * Created by francesco.rossato on 09/10/2017.
 */
public class Node <T> {
    private Node next;
    private T data;

    public Node(Node next, T data) {
        this.next = next;
        this.data = data;
    }

    public Node(T data) {
        this(null, data);
    }

    public Node(){
        this(null, null);
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public String toString(){
        return data.toString();
    }
}
