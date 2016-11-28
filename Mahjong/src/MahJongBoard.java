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
        //Image image = new
        setLayout(null);
        //setBackground(Color.black);
        setLocation(0,0);
        setSize(1100,700);
//        CharacterTile ct =new CharacterTile('4');
//        add(ct);
//        SeasonTile st = new SeasonTile("Winter");
//        add(st);
//        ct.setBounds(50,50,xBounds,yBounds);
//        st.setBounds(50+xLength,50,xBounds,yBounds);
//        Tile t = new Tile();
//        add(t);
//        t.setBounds(50+(2*xLength),50,xBounds,yBounds);
//        Tile t2 = new Tile();
//        add(t2);
//        t2.setBounds(50+(3*xLength),50,xBounds,yBounds);
//
//        CircleTile c = new CircleTile(1);
//        add(c);
//        c.setBounds(50+(4*xLength),50,xBounds,yBounds);
//        Bamboo1Tile b1 = new Bamboo1Tile();
//        add(b1);
//        b1.setBounds(50+(5*xLength),50,xBounds,yBounds);
//
//        BambooTile b = new BambooTile(4);
//        add(b);
//        b.setBounds(50+(6*xLength),50,xBounds,yBounds);
//
//        BambooTile b7 = new BambooTile(7);
//        add(b7);
//        b7.setBounds(50+(7*xLength),50,xBounds,yBounds);
//
//        CharacterTile c2 = new CharacterTile('N');
//        add(c2);
//        c2.setBounds(50+(8*xLength),50,xBounds,yBounds);

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

        setVisible(true);
    }

}
