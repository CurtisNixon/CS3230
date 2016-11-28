import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJong extends JFrame {
    private JPanel mahJongBoard = new JPanel();
    public MahJong(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mah Jong Tiles");
        setSize(1100,700);
        setLayout(null);
        add(new MahJongBoard());
        setVisible(true);

    }
    public static void main(String[] args){
        new MahJong();
    }
}
