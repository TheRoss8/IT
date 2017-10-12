import java.util.Scanner;

public class Palindrome{
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("\tPalindrom words!");
            System.out.print("Input a word: ");
            String w = in.nextLine().toLowerCase();
            Pila p = new Pila(w.length());
            Coda c = new Coda(w.length());
            boolean isPal = true;
            for(int i = 0; i < w.length(); i++){
                p.push(w.charAt(i));
                c.enqueue(w.charAt(i));
            }
            for(int i = 0; i < w.length(); i++){
                if(p.pop() != c.dequeue()){
                    isPal = false;
                    break;
                }
            }
            if(isPal)
                System.out.println("The word " + w + " is palindrome!! Be happy!");
            else
                System.out.println("The word " + w + " isn't palindrome, please don't be sad");
        }
}
