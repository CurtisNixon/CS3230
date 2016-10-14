import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class Tile extends JPanel {
    public boolean matches(Tile other){
        return this.getClass() == other.getClass();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(85,85);
    }

    public void paintComponent(Graphics g2){

        Graphics2D g = (Graphics2D)g2;
        super.paintComponent(g);

        //set colors
        Color green = new Color(50,242,50);
        Color darkGreen = new Color(3,142,1);
        Color ivory = new Color(237,230,158);
        Color white = new Color(255,255,255);
        Color black = new Color(0,0,0);
        GradientPaint greenGradient;
        GradientPaint ivoryGradient;

        //left side green
        int[] xPoints = new int[]{8,16,16,8};
        int[] yPoints = new int[]{16,8,64,72};
        greenGradient = new GradientPaint(8,48,green,16,8,darkGreen);
        g.setPaint(greenGradient);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(black);
        g.drawPolygon(xPoints, yPoints, 4);

        //bottom side green
        xPoints = new int[] {8,16,72,64};
        yPoints = new int[] {72,64,64,72};
        greenGradient = new GradientPaint(8,48,green,48,40,darkGreen);
        g.setPaint(greenGradient);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(black);
        g.drawPolygon(xPoints, yPoints, 4);

        //left side white
        xPoints = new int[] {16,24,24,16};
        yPoints = new int[] {8,0,56,64};
        ivoryGradient =  new GradientPaint(0,0,ivory,16,40,white);
        g.setPaint(ivoryGradient);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(black);
        g.drawPolygon(xPoints, yPoints, 4);

        //bottom side white
        xPoints = new int[] {16,24,80,72};
        yPoints = new int[] {64,56,56,64};
        ivoryGradient =  new GradientPaint(16,40,white,56,40,ivory);
        g.setPaint(ivoryGradient);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(black);
        g.drawPolygon(xPoints, yPoints, 4);

        //blank top of tile
        xPoints = new int[] {24,80,80,24};
        yPoints = new int[] {0,0,56,56};
        ivoryGradient =  new GradientPaint(24,32,white,56,0,ivory);
        g.setPaint(ivoryGradient);
        g.fillPolygon(xPoints, yPoints, 4);
        g.setColor(black);
        g.drawPolygon(xPoints, yPoints, 4);

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
