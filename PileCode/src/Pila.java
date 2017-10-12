public class Pila {
    private char[] stack;
    private int index = -1;

    public Pila(int length) {
        this.stack = new char[length];
    }

    public void push(char c){
        stack[++index] = c;
    }

    public char top(){
        return stack[index];
    }

    public char pop(){
        index--;
        return stack[index+1];
    }

    public boolean isEmpty(){
        return index == -1;
    }

    public boolean isFull(){
        return index == stack.length;
    }
}
