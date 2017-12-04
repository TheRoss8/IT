import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by francesco.rossato on 01/12/2017.
 */
public class WindowListener extends WindowAdapter{
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }

}
