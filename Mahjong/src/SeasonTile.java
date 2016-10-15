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
        //get the icon as an image and resize it
        Image image = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        Image newImage = new ImageIcon(image).getImage();
        g.drawImage(newImage, 27, 3, null);
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
