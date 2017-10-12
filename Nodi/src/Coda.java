public class Coda {
    private Nodo first;
    private Nodo last = null;

    public Coda(Object info){
        Nodo<Object> n = new Nodo<>(info);
        n.setNext(first);
        first = last = n;
    }

    public void enqueue(Object info){
        Nodo<Object> n = new Nodo<>(info);
        if(isEmpty()) {
            n.setNext(first);
            first = last = n;
        }
        else{
            last.setNext(n);
            last = n;
        }
    }

    public Object dequeue(){
        Nodo n = first;
        if(first.getNext() == null)
            last = null;
        first = first.getNext();
        return n.getContent();
    }

    public Object front(){
        return first.getContent();
    }

    public boolean isEmpty(){
        return first == null;
    }
}
