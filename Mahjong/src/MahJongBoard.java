import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJongBoard extends JPanel implements MouseListener {

    private static int xBounds = 73;
    private static int yBounds = 73;
    private static int xLength = 56;
    private static int yLength = 56;

    public MahJongBoard(){
        setLayout(null);
        setBackground(Color.ORANGE);
        setLocation(0,0);
        setSize(1100,700);
        MahJongModel  model = new MahJongModel();

        //top tile
        Tile t = model.topTile;
        t.addMouseListener(this);
        t.setBounds(490,225, xBounds, yBounds);
        add(t);

        //left most tile
        t = model.leftMostTile;
        t.addMouseListener(this);
        t.setBounds(64,285,xBounds, yBounds);
        add(t);

        int xPosition = 200;
        int yPosition = 10;
        for(int z = 4; z >= 0; z--) {
            xPosition = xPosition - 16;
            yPosition = yPosition + 16;
            for (int i = 8; i >= 0; i--) {
                for (int j = 0; j < 12; j++) {
                    if (model.tiles[i][j][z] != null) {
                        t = model.tiles[i][j][z];
                        t.setBounds(xPosition + j * xLength, yPosition + i * yLength, xBounds, yBounds);
                        t.addMouseListener(this);
                        add(t);
                    }
                }
            }
        }

        //right most tiles
        t = model.rightTileLeft;
        t.addMouseListener(this);
        t.setBounds(792, 285, xBounds, yBounds);
        add(t);

        t = model.rightTileRight;
        t.addMouseListener(this);
        t.setBounds(792 + xLength, 285, xBounds, yBounds);
        add(t);


        setVisible(true);
    }
    public void mouseClicked(MouseEvent e){
        //System.out.println(e.getSource());
        remove((Tile)e.getSource());
        revalidate();
        repaint();
    }
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mousePressed(MouseEvent e){}

    ImageIcon img = new ImageIcon(getClass().getResource("images/dragon_bg.png"));
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image image = img.getImage().getScaledInstance(1100,700,Image.SCALE_SMOOTH);
        g.drawImage(new ImageIcon(image).getImage(),0,0,this);

    }



}
