import com.sun.prism.paint.Color;

import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Button;

/**
 * Created by francesco.rossato on 01/12/2017.
 */
public class Listener implements MouseListener {
    private LinkedList ll;
    private TextField current;
    private TextField length;
    private TextField adder;
    private int pos = 0;

    public Listener(LinkedList ll, TextField current, TextField length, TextField adder) {
        this.ll = ll;
        this.current = current;
        this.length = length;
        this.adder = adder;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Button b = (Button)(e.getSource());
        switch(b.getLabel()){
            case "first":
                pos = 0;
                //b.setBackground(java.awt.Color.RED);
                current.setText("Current: " + ll.get(0));
                break;
            case "last":
                pos = ll.getLength()-1;
                //b.setBackground(java.awt.Color.RED);
                current.setText("Current: " + ll.get(pos));
                break;
            case "previous":
                if(pos > 0)
                    pos--;
                current.setText("Current: " + ll.get(pos));
                break;
            case "next":
                pos++;
                if(pos >= ll.getLength())
                    pos--;
                current.setText("Current: " + ll.get(pos));
                break;
            case "add":
                ll.add(adder.getText());
                length.setText("Length: " + ll.getLength());
                pos = ll.getLength()-1;
                current.setText("Current: " + ll.get(pos));
                break;
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
