import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by francesco.rossato on 09/10/2017.
 */
public class LinkedList <T> {
    private Node first = null;

    public LinkedList(T element) {
        this.first = new Node(element);
    }

    public LinkedList(T[] elements){
        this.first = new Node(elements[0]);
        Node n = first;
        for (int i = 1; i < elements.length; i++){
            n.setNext(new Node(elements[i]));
            n = n.getNext();
        }
    }

    public Object get(int pos){
        Node n = first;
        int i = 0;
        while(i < pos){
            n = n.getNext();
            i++;
        }
        return n.getData();
    }

    public void set(int pos, T element){
        Node n = first;
        int i = 0;
        while(i < pos){
            n = n.getNext();
            i++;
        }
        n.setData(element);
    }

    public void add(int pos, T element){
        Node n = first;
        int i = 0;
        while(i < pos-1){
            n = n.getNext();
            i++;
        }
        n.setNext(new Node(n.getNext(), element));
    }

    public void remove(int pos){
        Node n = first;
        int i = 0;
        while(i < pos){
            n = n.getNext();
            i++;
        }
        n.setNext(n.getNext().getNext());
    }

    public void addTail(T element){
        Node n = first;
        while(n.getNext() != null){
            n = n.getNext();
        }
        n.setNext(new Node(element));
    }

    public void addHead(T element){
        first = new Node(first, element);
    }

    public Object removeHead(){
        Node n = first;
        first = first.getNext();
        return n.getData();
    }

    public Object removeTail(){
        Node n = first;
        while(n.getNext().getNext() != null){
            n = n.getNext();
        }
        Object out = n.getNext().getData();
        n.setNext(null);
        return out;
    }

    public int getLength(){
        Node n = first;
        int len = 0;
        while(n != null){
            len++;
            n = n.getNext();
        }
        return len;
    }

    public String toString(){
        Node n = first;
        String out = "";
        while (n != null){
            out += n.toString();
            out += " ";
            n = n.getNext();
        }
        return out;
    }
}
