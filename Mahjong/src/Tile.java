import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class Tile extends JPanel {
    public boolean matches(Tile other){
        return this.getClass() == other.getClass();
    }
    public int xBound;
    public int yBound;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public int zOrder;
    public boolean highlightTile = false;
    public Tile(){
        setPreferredSize(new Dimension(73,72));
        setOpaque(false);
    }
    static Color green = new Color(50, 242, 50);
    static Color darkGreen = new Color(3, 142, 1);
    static Color ivory = new Color(237, 230, 158);
    static Color white = new Color(255, 255, 255);
    static Color black = new Color(0, 0, 0);
    static int[] xLeftGreen = new int[]{0,8,8,0};
    static int[] yLeftGreen = new int[]{16,8,64,72};
    static GradientPaint leftGreen = new GradientPaint(8,48,green,16,8,darkGreen);
    static int[] xBottomGreen = new int[] {0,8,64,56};
    static int[] yBottomGreen = new int[] {72,64,64,72};
    static GradientPaint bottomGreen = new GradientPaint(8,48,green,48,40,darkGreen);
    static int[] xLeftWhite = new int[] {8,16,16,8};
    static int[] yLeftWhite = new int[] {8,0,56,64};
    static GradientPaint leftWhite = new GradientPaint(0,0,ivory,16,40,white);
    static int[] xBottomWhite = new int[] {8,16,72,64};
    static int[] yBottomWhite = new int[] {64,56,56,64};
    static GradientPaint bottomWhite = new GradientPaint(16,40,white,56,40,ivory);
    static int[] xTile = new int[] {16,72,72,16};
    static int[] yTile = new int[] {0,0,56,56};
    static GradientPaint tileWhite = new GradientPaint(24,32,white,56,0,ivory);

    public void paintTile(Graphics2D g){

        //left side green
        g.setPaint(leftGreen);
        g.fillPolygon(xLeftGreen, yLeftGreen, 4);
        g.setColor(black);
        g.drawPolygon(xLeftGreen, yLeftGreen, 4);

        //bottom side green
        g.setPaint(bottomGreen);
        g.fillPolygon(xBottomGreen, yBottomGreen, 4);
        g.setColor(black);
        g.drawPolygon(xBottomGreen, yBottomGreen, 4);

        //left side white
        g.setPaint(leftWhite);
        g.fillPolygon(xLeftWhite, yLeftWhite, 4);
        g.setColor(black);
        g.drawPolygon(xLeftWhite, yLeftWhite, 4);

        //bottom side white
        g.setPaint(bottomWhite);
        g.fillPolygon(xBottomWhite, yBottomWhite, 4);
        g.setColor(black);
        g.drawPolygon(xBottomWhite, yBottomWhite, 4);

        //blank top of tile
        g.setPaint(tileWhite);
        g.fillPolygon(xTile, yTile, 4);
        g.setColor(black);
        g.drawPolygon(xTile, yTile, 4);
        if(highlightTile){
            g.setPaint(green);
            g.fillPolygon(xTile, yTile, 4);
        }
    }

    public void paintComponent(Graphics g2){

        Graphics2D g = (Graphics2D)g2;
        super.paintComponent(g);
        paintTile(g);

    }

    public void setXPosition(int x){
        xPosition = x;
    }

    public void setYPosition(int y){
        yPosition = y;
    }

    public void setZPosition(int z){
        zPosition = z;
    }

    public void setZOrder(int z){
        zOrder = z;
    }

    public void setZOrder()
    {
        zOrder = getParent().getComponentZOrder(this);
    }


    public void resetZOrder()
    {
        getParent().setComponentZOrder(this, zOrder);
    }


    public int getZOrder()
    {
        return zOrder;
    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());

        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tile");
        frame.setLocation(500,500);


        frame.add(new Tile());

        frame.pack();
        frame.setVisible(true);
    }

}
