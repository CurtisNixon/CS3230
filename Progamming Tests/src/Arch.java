import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import javax.swing.*;
import java.net.URL;
/**
 * Created by Curtis on 11/17/2016.
 */
public class Arch extends JFrame {
    private Image img;
    public Arch() {

        setSize(574, 584);
        setTitle("Arch");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        try{

            URL url = new URL("https://www.nps.gov/arch/photosmultimedia/upload/arches3.jpg");
            img = Toolkit.getDefaultToolkit().getImage(url);

        }catch(MalformedURLException ex){

            JOptionPane.showMessageDialog(this, "Bad URL:" + ex, "Image error", JOptionPane.ERROR_MESSAGE);

        }

        add(new Display());

        setVisible(true);
    }


    class Display extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            g.fill3DRect(0, 0, 574, 484, false);

            g.drawImage(img, 100, 100, this);

            g.setColor(Color.RED);
            Font font = g.getFont();
            Font newFont = font.deriveFont(font.getSize() * 1.5F);
            g.setFont(newFont);
            String text = "Delicate Arch";
            int width = g.getFontMetrics().stringWidth(text);
            int height = g.getFontMetrics().getHeight();
            width = (int)(574/2-(width*.5));
            height = (int)(534-(.5 * height));
            g.drawString(text, width, height);

        }
    }

    public static void main(String[] args){
        new Arch();
    }
}
