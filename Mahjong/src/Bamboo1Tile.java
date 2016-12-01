import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class Bamboo1Tile extends PictureTile {
    public Bamboo1Tile(){
        super("image of a sparrow");
    }
    public String toString(){
        return "Bamboo 1";
    }

    public void paintBamboo1Tile(Graphics g){
        //get the icon as an image and resize it
        ImageIcon icon = new ImageIcon(getClass().getResource("images/Sparrow.png"));
        Image image = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        Image newImage = new ImageIcon(image).getImage();
        g.drawImage(newImage, 21, 3, this);
        setToolTipText(toString());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintBamboo1Tile(g);

    }
        public static void main(String[] args)
        {
            JFrame	frame = new JFrame();

            frame.setLayout(new FlowLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Bamboo 1 Tile");

            frame.add(new Bamboo1Tile());

            frame.pack();
            frame.setVisible(true);
        }

    }
