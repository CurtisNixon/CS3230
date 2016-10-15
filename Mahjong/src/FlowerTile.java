import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 9/28/2016.
 */
public class FlowerTile extends PictureTile {
    public FlowerTile(String name){
        super(name);
    }

    public void paintFlowerTile(Graphics g){
        String name = super.toString();
        ImageIcon icon = null;
        if(name.equals("Chrysanthemum")){
            icon = new ImageIcon("images/Chrysanthemum.png");
        }else if(name.equals("Orchid")){
            icon = new ImageIcon("images/Orchid.png");
        }else if(name.equals("Plum")){
            icon = new ImageIcon("images/Plum.png");
        }else if(name.equals("Bamboo")){
            icon = new ImageIcon("images/Bamboo.png");
        }
        //get the icon as an image and resize it
        Image image = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        Image newImage = new ImageIcon(image).getImage();
        g.drawImage(newImage, 27, 3, null);
        setToolTipText(name);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintFlowerTile(g);

    }

    public static void main(String[] args)
    {
        JFrame	frame = new JFrame();

        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Flower Tiles");

        frame.add(new FlowerTile("Chrysanthemum"));
        frame.add(new FlowerTile("Orchid"));
        frame.add(new FlowerTile("Plum"));
        frame.add(new FlowerTile("Bamboo"));

        frame.pack();
        frame.setVisible(true);
    }
}
