import java.util.Random;

public class Inverter {
    public static void main(String[] args) {
        final int MAX = 10;
        int length = new Random().nextInt(MAX)+5;
        Pila p = new Pila(length+1);
        Coda c = new Coda (length+1);
        System.out.println("Generating a random queue...");
        while(!c.isFull()){
            char rnd = (char)(new Random().nextInt(26)+97);
            System.out.print(rnd + " ");
            c.enqueue(rnd);
        }
        while(!c.isEmpty())
            p.push(c.dequeue());
        System.out.println("\n... and its reverse!");
        while(!p.isEmpty())
            System.out.print(p.pop() + " ");
    }
}
