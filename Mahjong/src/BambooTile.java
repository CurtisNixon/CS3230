import java.awt.*;
import javax.swing.*;
/**
 * Created by Curtis on 9/28/2016.
 */
public class BambooTile extends RankTile {
    public BambooTile(int rank){
        super(rank);
    }
    public String toString(){
        return "Bamboo " + rank;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setToolTipText(toString());
        Color green = new Color(0,221,0);
        Color red = new Color(173,0,0);
        Color blue = new Color(0,0,142);
        switch(rank){
            case 2:
                g.setColor(blue);
                paintBambooStick(48,12,g);
                g.setColor(green);
                paintBambooStick(48,29,g);
                break;
            case 3:
                g.setColor(blue);
                paintBambooStick(48,12,g);
                g.setColor(green);
                paintBambooStick(38,29,g);
                paintBambooStick(58,29,g);
                break;
            case 4:
                g.setColor(blue);
                paintBambooStick(36,12,g);
                paintBambooStick(60,29,g);
                g.setColor(green);
                paintBambooStick(36,29,g);
                paintBambooStick(60,12,g);
                break;
            case 5:
                g.setColor(red);
                paintBambooStick(48,20,g);
                g.setColor(green);
                paintBambooStick(36,12,g);
                paintBambooStick(60,29,g);
                g.setColor(blue);
                paintBambooStick(36,29,g);
                paintBambooStick(60,12,g);
                break;
            case 6:
                g.setColor(green);
                paintBambooStick(31,12,g);
                paintBambooStick(65,12,g);
                paintBambooStick(48,12,g);
                g.setColor(blue);
                paintBambooStick(31, 29, g);
                paintBambooStick(65,29,g);
                paintBambooStick(48,29,g);
                break;
            case 7:
                g.setColor(green);
                paintBambooStick(31,21,g);
                paintBambooStick(31,39,g);
                paintBambooStick(65,21,g);
                paintBambooStick(65,39,g);
                g.setColor(blue);
                paintBambooStick(48,21,g);
                paintBambooStick(48,39,g);
                g.setColor(red);
                paintBambooStick(48,3,g);
                break;
            case 8:
                g.setColor(green);
                paintBambooStick(31,3,g);
                paintBambooStick(65,3,g);
                paintBambooStick(48,3,g);
                g.setColor(red);
                paintBambooStick(40,21,g);
                paintBambooStick(57,21,g);
                g.setColor(blue);
                paintBambooStick(31,39,g);
                paintBambooStick(65,39,g);
                paintBambooStick(48,39,g);
                break;
            case 9:
                g.setColor(red);
                paintBambooStick(31,3,g);
                paintBambooStick(31,21,g);
                paintBambooStick(31,39,g);
                g.setColor(blue);
                paintBambooStick(48,21,g);
                paintBambooStick(48,39,g);
                paintBambooStick(48,3,g);
                g.setColor(green);
                paintBambooStick(65,3,g);
                paintBambooStick(65,21,g);
                paintBambooStick(65,39,g);
                break;
        }
    }

    private void paintBambooStick(int xPosition, int yPosition, Graphics g){
        g.draw3DRect(xPosition, yPosition, 8, 15,false);
        //TODO draw stick instead of rectangle
    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bamboo Tiles");

        frame.add(new BambooTile(2));
        frame.add(new BambooTile(3));
        frame.add(new BambooTile(4));
        frame.add(new BambooTile(5));
        frame.add(new BambooTile(6));
        frame.add(new BambooTile(7));
        frame.add(new BambooTile(8));
        frame.add(new BambooTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
