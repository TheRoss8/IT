import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.GridLayout;
import java.awt.Dimension;

/**
 * Created by francesco.rossato on 27/11/2017.
 */
public class GUI {
    protected  LinkedList ll = new LinkedList();

    public static void main(String[] args) {
        File file = new File("in.txt");
        Scanner in = null;
        /*try {
            in = new Scanner(file);
        } catch(FileNotFoundException fnf){
            fnf.printStackTrace();
        }*/
        LinkedList ll = new LinkedList();
        /*while(in.hasNextLine())
            ll.add(in.nextLine());*/

        Frame f = new Frame("List");
        Button first = new Button("first");
        Button last = new Button("last");
        Button previous = new Button("previous");
        Button next = new Button("next");
        Button add = new Button ("add");
        Button del = new Button ("del");
        TextField current = new TextField();
        TextField length = new TextField();
        TextField adder = new TextField();

        length.setEditable(false);
        current.setEditable(false);
        f.setSize(new Dimension(500, 300));
        f.setLayout(new GridLayout(3, 3));

        Listener l = new Listener(ll, current, length, adder);
        f.addWindowListener(new WindowListener());
        first.addMouseListener(l);
        last.addMouseListener(l);
        previous.addMouseListener(l);
        next.addMouseListener(l);
        add.addMouseListener(l);
        del.addMouseListener(l);

        f.add(first);
        f.add(length);
        f.add(last);
        f.add(previous);
        f.add(current);
        f.add(next);
        f.add(add);
        f.add(adder);
        f.add(del);

        f.setVisible(true);
    }
}
