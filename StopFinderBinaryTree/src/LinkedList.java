import java.util.Iterator;

/**
 * Class that represents an iterable linked list
 * @param <T> The list's element type
 */
public class LinkedList <T> implements Iterable{
    private Node first;

    /**
     * Class constructor that sets the first element in the LinkedList
     * @param first The first element of the list
     */
    public LinkedList(T first) {
        this.first = new Node(first, null);
    }

    /**
     * Class constructor for an empty initial list
     */
    public LinkedList(){}

    /**
     * Gets the element in the given position
     * @param pos The position
     * @return The element in the given position
     */
    public Object get(int pos){
        if(pos < 0 || pos >= getLength())
            throw new IllegalArgumentException("Position too big or negative");
        Node n = first;
        for(int i = 0 ; i < pos; i++)
            n = n.getNext();
        return n.getInfo();
    }

    /**
     * Gets the list's length
     * @return The list's length
     */
    public int getLength(){
        int length = 0;
        Node n = first;
        while(n != null) {
            length++;
            n = n.getNext();
        }
        return length;
    }

    /**
     * Appends the given item to the tail of the list
     * @param item The item to append
     */
    public void add(T item){
        if(first == null)
            first = new Node(item, null);
        else{
            Node n = first;
            while(n.getNext() != null)
                n = n.getNext();
            n.setNext(new Node(item, null));
        }
    }
    public void add(LinkedList list){
        for(Object element : list)
            add((T)element);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int pos = 0;
            @Override
            public boolean hasNext() {
                return pos < getLength();
            }
            @Override
            public Object next() {
                return get(pos++);
            }
        };
    }
}
