import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class Tile extends JPanel {
    public boolean matches(Tile other){
        return this.getClass() == other.getClass();
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(50,242,50));
        g.fill3DRect(0,8,100,100,true);
        g.setColor(new Color(255,255,255));
        g.fill3DRect(8,2,100,100,true);

    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        //frame.setLayout(new FlowLayout());

        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");


        frame.add(new Tile());

        frame.pack();
        frame.setVisible(true);
    }

}
