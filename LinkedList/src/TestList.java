import java.util.Random;
import java.util.Scanner;

/**
 * Created by francesco.rossato on 09/10/2017.
 */
public class TestList {
    public static void main(String[] args) {
        final int LEN = 10;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        String[] words = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        System.out.println("Declaring the List with the String[]");
        LinkedList ll = new LinkedList(words);
        System.out.println("Printing...");
        System.out.println(ll.toString());
        int ran = rnd.nextInt(LEN);
        System.out.println("Getting element number " + ran + ": " + ll.get(ran));
        System.out.println("Removing last element and printing...");
        ll.removeTail();
        System.out.println(ll.toString());
        System.out.println("Removing first element and printing...");
        ll.removeHead();
        System.out.println(ll.toString());
        System.out.println("Getting length...");
        System.out.println(ll.getLength());
        ran = rnd.nextInt(ll.getLength());
        System.out.println("Removing element in position " + ran + " and printing... ");
        ll.remove(ran);
        System.out.println(ll.toString());
        ran = rnd.nextInt(100);
        System.out.println("Adding " + ran + " from the head and printing...");
        ll.addHead(ran);
        System.out.println(ll.toString());
        ran = rnd.nextInt(100);
        System.out.println("Adding " + ran + " from the tail and printing...");
        ll.addTail(ran);
        System.out.println(ll.toString());
        int ran2 = rnd.nextInt(ll.getLength());
        ran = rnd.nextInt(100);
        System.out.println("Adding " + ran + " in position " + ran2 + " and printing...");
        ll.add(ran2, ran);
        System.out.println(ll.toString());
    }
}
