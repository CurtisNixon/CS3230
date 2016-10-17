import java.awt.*;
import javax.swing.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class WhiteDragonTile extends Tile {

    public WhiteDragonTile(){
        super();
    }
    public String toString(){
        return "White Dragon";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //outer border
        g.setColor(new Color(6,61,163));
        g.draw3DRect(29,6,46,46,false);
        //inner border
        g.draw3DRect(36,13,32,32,false);

        //blue rectangular fills
        //top
        g.fill3DRect(29,6,9,8,false);
        g.fill3DRect(44,6,9,8,false);
        g.fill3DRect(60,6,9,8,false);
        //right
        g.fill3DRect(68,14,7,9,false);
        g.fill3DRect(68,30,7,9,false);
        g.fill3DRect(68,45,7,8,false);
        //bottom
        g.fill3DRect(37,45,9,8,false);
        g.fill3DRect(54,45,9,8,false);
        //left
        g.fill3DRect(29,20,8,9,false);
        g.fill3DRect(29,37,8,9,false);
        setToolTipText(toString());

    }
    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("White Dragon Tile");

        frame.add(new WhiteDragonTile());

        frame.pack();
        frame.setVisible(true);
    }
}
