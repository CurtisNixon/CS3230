import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class SeasonTile extends PictureTile {
    public SeasonTile(String name){
        super(name);
    }

    // valid seasons are Spring Summer Fall Winter

    public void paintSeasonTile(Graphics g){
        String name = super.toString();
        ImageIcon icon = null;
        if(name.equals("Spring")){
            icon = new ImageIcon(getClass().getResource("images/Spring.png"));
        }else if(name.equals("Summer")){
            icon = new ImageIcon(getClass().getResource("images/Summer.png"));
        }else if(name.equals("Fall")){
            icon = new ImageIcon(getClass().getResource("images/Fall.png"));
        }else if(name.equals("Winter")){
            icon = new ImageIcon(getClass().getResource("images/Winter.png"));
        }
        //get the icon as an image and resize it
        Image image = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        Image newImage = new ImageIcon(image).getImage();
        g.drawImage(newImage, 19, 3, null);
        setToolTipText(name);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintSeasonTile(g);

    }


    public static void main(String[] args)
    {

        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Season Tiles");

        frame.add(new SeasonTile("Spring"));
        frame.add(new SeasonTile("Summer"));
        frame.add(new SeasonTile("Fall"));
        frame.add(new SeasonTile("Winter"));

        frame.pack();
        frame.setVisible(true);
    }
}
