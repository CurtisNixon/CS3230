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
        Color green = new Color(0,150,0);
        Color red = new Color(173,0,0);
        Color blue = new Color(0,0,142);
        switch(rank){
            case 2:
                g.setColor(blue);
                paintBambooStick(40,12,g);
                g.setColor(green);
                paintBambooStick(40,29,g);
                break;
            case 3:
                g.setColor(blue);
                paintBambooStick(40,12,g);
                g.setColor(green);
                paintBambooStick(30,29,g);
                paintBambooStick(50,29,g);
                break;
            case 4:
                g.setColor(blue);
                paintBambooStick(28,12,g);
                paintBambooStick(52,29,g);
                g.setColor(green);
                paintBambooStick(28,29,g);
                paintBambooStick(52,12,g);
                break;
            case 5:
                g.setColor(red);
                paintBambooStick(40,20,g);
                g.setColor(green);
                paintBambooStick(28,12,g);
                paintBambooStick(52,29,g);
                g.setColor(blue);
                paintBambooStick(30,29,g);
                paintBambooStick(52,12,g);
                break;
            case 6:
                g.setColor(green);
                paintBambooStick(23,12,g);
                paintBambooStick(57,12,g);
                paintBambooStick(40,12,g);
                g.setColor(blue);
                paintBambooStick(23, 29, g);
                paintBambooStick(57,29,g);
                paintBambooStick(40,29,g);
                break;
            case 7:
                g.setColor(green);
                paintBambooStick(23,21,g);
                paintBambooStick(23,39,g);
                paintBambooStick(57,21,g);
                paintBambooStick(57,39,g);
                g.setColor(blue);
                paintBambooStick(40,21,g);
                paintBambooStick(40,39,g);
                g.setColor(red);
                paintBambooStick(40,3,g);
                break;
            case 8:
                g.setColor(green);
                paintBambooStick(23,3,g);
                paintBambooStick(57,3,g);
                paintBambooStick(40,3,g);
                g.setColor(red);
                paintBambooStick(32,21,g);
                paintBambooStick(49,21,g);
                g.setColor(blue);
                paintBambooStick(23,39,g);
                paintBambooStick(57,39,g);
                paintBambooStick(40,39,g);
                break;
            case 9:
                g.setColor(red);
                paintBambooStick(23,3,g);
                paintBambooStick(23,21,g);
                paintBambooStick(23,39,g);
                g.setColor(blue);
                paintBambooStick(40,21,g);
                paintBambooStick(40,39,g);
                paintBambooStick(40,3,g);
                g.setColor(green);
                paintBambooStick(57,3,g);
                paintBambooStick(57,21,g);
                paintBambooStick(57,39,g);
                break;
        }
    }

    private void paintBambooStick(int x, int y, Graphics g){
        g.drawLine(x+2,y,x+6,y);
        g.drawLine(x+1,y+1,x+4,y+1);g.drawLine(x+6,y+1,x+7,y+1);
        g.drawLine(x,y+2,x+4,y+2);g.drawLine(x+6,y+2,x+8,y+2);
        g.drawLine(x,y+3,x+4,y+3);g.drawLine(x+6,y+3,x+8,y+3);

        g.drawLine(x+2,y+4,x+4,y+4);g.drawLine(x+6,y+4,x+6,y+4);
        g.drawLine(x+2,y+5,x+4,y+5);g.drawLine(x+6,y+5,x+6,y+5);
        g.drawLine(x+2,y+6,x+4,y+6);g.drawLine(x+6,y+6,x+6,y+6);
        g.drawLine(x+1,y+7,x+7,y+7);
        g.drawLine(x,y+8,x+8,y+8);
        g.drawLine(x,y+9,x+8,y+9);

        g.drawLine(x+2,y+10,x+4,y+10);g.drawLine(x+6,y+10,x+6,y+10);
        g.drawLine(x+2,y+11,x+4,y+11);g.drawLine(x+6,y+11,x+6,y+11);
        g.drawLine(x+2,y+12,x+4,y+12);g.drawLine(x+6,y+12,x+6,y+12);
        g.drawLine(x+1,y+13,x+4,y+13);g.drawLine(x+6,y+13,x+7,y+13);
        g.drawLine(x,y+14,x+4,y+14);g.drawLine(x+6,y+14,x+8,y+14);
        g.drawLine(x,y+15,x+8,y+15);

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
