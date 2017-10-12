public class Coda {
    private char[] queue;
    private int index = -1;

    public Coda(int length){
        this.queue = new char[length];
    }

    public void enqueue(char c){
        queue[++index] = c;
    }

    public char front(){
        return queue[0];
    }

    public char dequeue(){
        char c = queue[0];
        for(int i = 0; i < index; i++){
            queue[i] = queue[i+1];
        }
        index--;
        return c;
    }

    public boolean isEmpty(){
        return index == -1;
    }

    public boolean isFull(){
        return index == queue.length-1;
    }
}
