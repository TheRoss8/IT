import java.util.Iterator;

public class LinkedList <T> implements Iterable{
    private Node first;

    public LinkedList(Node first) {
        this.first = first;
    }
    public LinkedList(){}

    public Object get(int pos){
        if(pos < 0 || pos >= getLength())
            throw new IllegalArgumentException("Position too big or negative");
        Node n = first;
        for(int i = 0 ; i < pos; i++)
            n = n.getNext();
        return n.getInfo();
    }
    public int getLength(){
        int length = 0;
        Node n = first;
        while(n != null) {
            length++;
            n = n.getNext();
        }
        return length;
    }

    public void add(Object item){
        if(first == null)
            first = new Node(item, null);
        else{
            Node n = first;
            while(n.getNext() != null)
                n = n.getNext();
            n.setNext(new Node(item, null));
        }
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
