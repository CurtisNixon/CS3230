import java.awt.*;
import javax.swing.*;
/**
 * Created by Curtis on 9/28/2016.
 */
public class CircleTile extends RankTile {
    public CircleTile(int rank){
        super(rank);

    }
    public String toString(){
        return "Circle " + rank;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color green = new Color(0,150,0);
        Color red = new Color(173,0,0);
        Color blue = new Color(0,0,142);
        switch(rank){
            case 1:

                g.setColor(green);
                g.fillOval(30,6,44,44);
                g.setColor(Color.black);
                g.drawOval(30,6,44,44);
                g.setColor(red);
                drawCircle(47,21,12,red,g);
                g.setColor(Color.WHITE);
                g.drawOval(47,21,12,12);
                //left
                g.fillOval(39,25,4,4);
                g.fillOval(41,20,4,4);
                g.fillOval(45,16,4,4);
                //top
                g.fillOval(57,15,4,4);
                g.fillOval(51,14,4,4);
                g.fillOval(61,19,4,4);
                //right
                g.fillOval(63,25,4,4);
                g.fillOval(61,31,4,4);
                g.fillOval(57,36,4,4);
                //bottom
                g.fillOval(51,39,4,4);
                g.fillOval(45,37,4,4);
                g.fillOval(41,32,4,4);

                break;
            case 2:
                g.setColor(green);
                drawCircle(39, 2, 26, green,g);
                g.setColor(red);
                drawCircle(39,28,26,red,g);
                 break;
            case 3:
                g.setColor(blue);
                drawCircle(25,1,18,blue,g);
                g.setColor(red);
                drawCircle(42, 18, 18, red, g);
                g.setColor(green);
                drawCircle(60,37,18,green,g);
                break;
            case 4:
                g.setColor(blue);
                drawCircle(30,6,22,blue,g);
                drawCircle(52, 29, 22, blue, g);
                g.setColor(green);
                drawCircle(52,6,22,green,g);
                drawCircle(30,29,22,green,g);
                break;
            case 5:
                g.setColor(blue);
                drawCircle(25,1,18,blue,g);
                drawCircle(60,37,18,blue,g);
                g.setColor(green);
                drawCircle(25,37,18,green,g);
                drawCircle(60,1,18,green,g);
                g.setColor(red);
                drawCircle(43,19,18,red,g);
                break;
            case 6:
                g.setColor(green);
                drawCircle(33,1,18,green,g);
                drawCircle(53,1,18,green,g);
                g.setColor(red);
                drawCircle(33,19,18,red,g);
                drawCircle(53,19,18,red,g);
                drawCircle(33,37,18,red,g);
                drawCircle(53,37,18,red,g);
                break;
            case 7:
                g.setColor(green);
                drawCircle(28,5,12,green,g);
                drawCircle(46,11,12,green,g);
                drawCircle(64,17,12,green,g);
                g.setColor(red);
                drawCircle(35,28,12,red,g);
                drawCircle(55,28,12,red,g);
                drawCircle(35,42,12,red,g);
                drawCircle(55,42,12,red,g);
                break;
            case 8:
                g.setColor(blue);
                drawCircle(35,2,12,blue,g);
                drawCircle(55,2,12,blue,g);
                drawCircle(35,15,12,blue,g);
                drawCircle(55,15,12,blue,g);
                drawCircle(35,28,12,blue,g);
                drawCircle(55,28,12,blue,g);
                drawCircle(35,42,12,blue,g);
                drawCircle(55,42,12,blue,g);
                break;
            case 9:
                g.setColor(green);
                drawCircle(25,1,18,green,g);
                drawCircle(43,1,18,green,g);
                drawCircle(61,1,18,green,g);
                g.setColor(red);
                drawCircle(25,19,18,red,g);
                drawCircle(43,19,18,red,g);
                drawCircle(61,19,18,red,g);
                g.setColor(blue);
                drawCircle(25,37,18,blue,g);
                drawCircle(43,37,18,blue,g);
                drawCircle(61,37,18,blue,g);
                break;



        }


        setToolTipText(toString());
    }

    public void drawCircle(int x, int y,int diameter,Color color,Graphics g){
        double hypotenuse = Math.sqrt((diameter*diameter)+(diameter*diameter));
        double outsideCircle = (hypotenuse-diameter)/2;
        g.fillOval(x,y,diameter,diameter);
        Color c = new Color(255,255,255);
        g.setColor(c);
        g.drawLine(x+(int)outsideCircle,y+(int)outsideCircle,x+diameter-(int)outsideCircle,y+diameter-(int)outsideCircle);
        g.drawLine(x+(int)outsideCircle,y+diameter-(int)outsideCircle,x+diameter-(int)outsideCircle,y+(int)outsideCircle);
        g.setColor(color);

    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Circle Tiles");

        frame.add(new CircleTile(1));
        frame.add(new CircleTile(2));
        frame.add(new CircleTile(3));
        frame.add(new CircleTile(4));
        frame.add(new CircleTile(5));
        frame.add(new CircleTile(6));
        frame.add(new CircleTile(7));
        frame.add(new CircleTile(8));
        frame.add(new CircleTile(9));

        frame.pack();
        frame.setVisible(true);
    }
}
