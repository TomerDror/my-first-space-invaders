import java.awt.*;
import javax.swing.*;

public class Window extends JFrame{

    private myPanel panel;

    private int width;
    private int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;


        myPanel panel = new myPanel(this.width, this.height);   

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(width, height);
        this.add(panel);
        this.pack();
        // this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    
}
