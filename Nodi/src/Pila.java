public class Pila implements iPila{

    private Nodo first;


    public Pila(Object info){
        first = new Nodo(info);
    }

    public Pila(){
        this(null);
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(Object info){
        Nodo<Object> n = new Nodo<>(info);
        n.setNext(first);
        first = n;
    }

    public Object pop(){
        if(!isEmpty()) {
            Object out = first.getContent();
            first = first.getNext();
            return out;
        }
        return null;
    }

    public Object top(){
        return first.getContent();
    }

}
