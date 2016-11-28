import java.awt.*;
import javax.swing.*;
/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJongBoard extends JPanel {

    private static int xBounds = 73;
    private static int yBounds = 73;
    private static int xLength = 56;
    private static int yLength = 56;

    public MahJongBoard(){
        setLayout(null);
        //TODO set background image
        //Image image = new
        //setBackground(Color.black);
        setLocation(0,0);
        setSize(1100,700);

        MahJongModel  model = new MahJongModel();

        Tile t = model.topTile;
        add(t);
        t.setBounds(490,225, xBounds, yBounds);

        int xPosition = 200;
        int yPosition = 10;
        for(int z = 4; z >= 0; z--) {
            xPosition = xPosition - 16;
            yPosition = yPosition + 16;
            for (int i = 8; i >= 0; i--) {
                for (int j = 0; j < 12; j++) {
                    if (model.tiles[i][j][z] != null) {
                        t = model.tiles[i][j][z];
                        add(t);
                        t.setBounds(xPosition + j * xLength, yPosition + i * yLength, xBounds, yBounds);
                    }
                }
            }
        }
        //TODO set click handlers and check if a Tile is clickable

        setVisible(true);
    }

}
