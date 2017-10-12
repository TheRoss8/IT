public class Nodo <T>{

    private Nodo next;
    private T content;

    public Nodo(T content, Nodo next){
        this.content = content;
        this.next = next;
    }

    public Nodo(T content){
        this(content, null);
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Nodo getNext(){
        return next;
    }

    public T getContent(){
        return content;
    }
}
