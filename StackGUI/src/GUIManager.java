import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

/**
 * Created by francesco.rossato on 04/12/2017.
 */
public class GUIManager extends Frame implements ActionListener{
    private Stack stack;
    private Button push;
    private Button pop;
    private TextField peek;
    private TextField insert;

    public GUIManager(Stack stack, String title){
        super(title);

        this.stack = stack;
        stack = new Stack();

        push = new Button("push");
        pop = new Button("pop");
        peek = new TextField("");
        insert = new TextField("");
        push.addActionListener(this);
        pop.addActionListener(this);
        peek.setEditable(false);

        setLayout(new GridLayout(2, 2));
        setSize(600, 500);
        setVisible(true);
        add(insert);
        add(push);
        add(peek);
        add(pop);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == push) {
            if (!(insert.getText() == "")) ;
            stack.push(insert.getText());
            peek.setText(stack.peek().toString());
        }
        else if(e.getSource() == pop) {
            if (!stack.empty())
                peek.setText(stack.pop().toString());
            else
                peek.setText("the stack is empty");
        }
    }
}
