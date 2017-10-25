public class Node<T> {
    private T info;
    private Node next;

    public Node(T info, Node next) {
        this.info = info;
        this.next = next;
    }

    public T getInfo() {
        return info;
    }
    public Node getNext() {
        return next;
    }

    public void setInfo(T info) {
        this.info = info;
    }
    public void setNext(Node next) {
        this.next = next;
    }
}
