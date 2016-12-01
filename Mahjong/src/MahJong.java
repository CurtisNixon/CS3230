import javax.swing.*;
import java.awt.*;

/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJong extends JFrame {
    public MahJong(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mah Jong by Curtis Nixon");
        setSize(1100,700);
        setLayout(null);
        add(new MahJongBoard());
        setVisible(true);

    }
    public static void main(String[] args){
        new MahJong();
    }
}
