import java.awt.*;
import javax.swing.*;
/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJongBoard extends JPanel {

    public MahJongBoard(){
        //Image image = new
        setBackground(Color.black);
        setLocation(0,0);
        setSize(1500,900);
        add(new CharacterTile('4'));
       // setLocation(100,100);
       // setSize(50,50);
        add(new SeasonTile("Winter"));

       //MahJongModel model = new MahJongModel();
       // add(model.tiles[0][0][0]);
//        for(int i = 0; i < 9; i++){
//            for(int j = 0; j < 12; j++) {
//                if(model.tiles[i][j][0] != null) {
//                    add(model.tiles[i][j][0]);
//                }
//            }
//        }
       // setVisible(true);
    }

}
