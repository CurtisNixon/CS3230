import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Created by Curtis on 12/7/2016.
 */
public class GUI extends JFrame {
    private JPanel panel = new JPanel();

    GUI(){
        setTitle("Menu Demo");
        setSize(400, 200);
        addWindowListener(new WindowAdapter()
        { public void windowClosing(WindowEvent e)
        { System.exit(0); }
        });

        makeMenuBar();

        panel.setLayout(new BorderLayout());

        JButton north = new JButton("North");
        north.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                north();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(north);
        panel.add(buttonPanel, BorderLayout.NORTH);

        JButton south = new JButton("South");
        south.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                south();
            }
        });
        buttonPanel = new JPanel();
        buttonPanel.add(south);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        JButton east = new JButton("East");
        east.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                east();
            }
        });
        buttonPanel = new JPanel();
        buttonPanel.add(east);
        panel.add(buttonPanel, BorderLayout.EAST);

        JButton west = new JButton("West");
        west.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                west();
            }
        });
        buttonPanel = new JPanel();
        buttonPanel.add(west);
        panel.add(buttonPanel, BorderLayout.WEST);


        add(panel);
        setVisible(true);
    }

    private void makeMenuBar(){
        JMenuBar	menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu	topMenu = new JMenu("Directions");
        menuBar.add(topMenu);

        JMenuItem north = new JMenuItem("North", 'N');
        topMenu.add(north);
        north.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                north();
            }
        });

        JMenuItem south = new JMenuItem("South", 'S');
        topMenu.add(south);
        south.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                south();
            }
        });

        JMenuItem east = new JMenuItem("East", 'E');
        topMenu.add(east);
        east.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                east();
            }
        });

        JMenuItem west = new JMenuItem("West", 'W');
        topMenu.add(west);
        west.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                west();
            }
        });
    }

    public void north(){
        JOptionPane.showConfirmDialog(this,"North","Direction",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }

    public void south(){
        JOptionPane.showConfirmDialog(this,"South","Direction",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }

    public void east(){
        JOptionPane.showConfirmDialog(this,"East","Direction",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }

    public void west(){
        JOptionPane.showConfirmDialog(this,"West","Direction",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        new GUI();
    }
}
