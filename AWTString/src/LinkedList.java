import java.util.Iterator;

/**
 * Created by francesco.rossato on 27/11/2017.
 */
public class LinkedList<T> implements Iterable {
    private Node first = null;
    private Node current = first;

    public LinkedList(T element){
        this.first = new Node(element);
    }
    public LinkedList(){

    }

    public void add(T info){
        if(first == null)
            first = new Node(info);
        else {
            Node temp = first;
            while(temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(new Node(info));
            temp.getNext().setPrevious(temp);
        }
    }
    public Object get(int pos){
        if(pos < 0 || pos >= getLength())
            throw new IllegalArgumentException("Position too big or negative");
        Node temp = first;
        for(int i = 0; i < pos; i++)
            temp = temp.getNext();
        return temp.getInfo();
    }
    public int getLength(){
        Node temp = first;
        int length = 0;
        while(temp != null){
            temp = temp.getNext();
            length++;
        }
        return length;
    }
    public Object getCurrent(){
        return current.getInfo();
    }
    public void next(){
        if(hasNext())
            current = current.getNext();
    }
    public void previous(){
        if(hasPrevious())
            current = current.getPrevious();
    }
    public boolean hasPrevious(){
        return current.getPrevious() != null;
    }
    public boolean hasNext(){
        return current.getNext() != null;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int pos = 0;
            @Override
            public boolean hasNext() {
                return getLength() > pos;
            }
            @Override
            public Object next() {
                return get(pos++);
            }
        };
    }
}
