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
    //TODO make sure images are located in the right place for testing


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        String name = super.toString();
        ImageIcon icon;
        if(name.equals("Spring")){
            icon = new ImageIcon("images/Spring.png");
        }else if(name.equals("Summer")){
            icon = new ImageIcon("images/Summer.png");
        }else if(name.equals("Fall")){
            icon = new ImageIcon("images/Fall.png");
        }else if(name.equals("Winter")){
            icon = new ImageIcon("images/Winter.png");
        }else{
            icon = new ImageIcon();
        }
        //TODO resize the images
        Image image = icon.getImage();
        image.getScaledInstance(10,10,Image.SCALE_DEFAULT);
        g.drawImage(image, 20, 0, null);
        setToolTipText(super.toString());

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
