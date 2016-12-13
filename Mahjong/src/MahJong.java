import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJong extends JFrame {
    private MahJongBoard board;
    public MahJong(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mah Jong by Curtis Nixon");
        setSize(1100,700);
        setLayout(null);
        board = new MahJongBoard();
        add(board);
        makeMenu();
        setVisible(true);

    }

    private void makeMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic('G');
        menuBar.add(gameMenu);

        JMenuItem play = new JMenuItem("Play",'P');
        play.setToolTipText("Start a new game");
        play.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
        gameMenu.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        JMenuItem restart = new JMenuItem("Restart",'R');
        restart.setToolTipText("Restart the current game");
        restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        gameMenu.add(restart);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });

        JMenuItem numbered = new JMenuItem("Numbered",'N');
        numbered.setToolTipText("Play a numbered game");
        numbered.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        gameMenu.add(numbered);
        numbered.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numbered();
            }
        });

        JMenu soundMenu = new JMenu("Sound");
        soundMenu.setMnemonic('S');
        menuBar.add(soundMenu);

        //TODO this sound option
        JMenuItem sound = new JMenuItem("Sound",'S');
        sound.setToolTipText("Start a new game");
        sound.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
        soundMenu.add(sound);
        sound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sound();
            }
        });

        JMenu moveMenu = new JMenu("Move");
        moveMenu.setMnemonic('M');
        menuBar.add(moveMenu);

        JMenuItem undo = new JMenuItem("Undo",'U');
        undo.setToolTipText("Undo last move");
        undo.setAccelerator(KeyStroke.getKeyStroke("ctrl U"));
        moveMenu.add(undo);
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });


        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        menuBar.add(helpMenu);

        JMenuItem rules = new JMenuItem("Game Rules",'G');
        rules.setToolTipText("Rules of the game");
        rules.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
        helpMenu.add(rules);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rules();
            }
        });
    }

    public void play(){
        //TODO JOptionPane for confirmation or cancel
        remove(board);
        board = new MahJongBoard();
        add(board);
        repaint();
    }

    public void restart(){
        //TODO restart the same game
    }

    public void numbered(){
        //TODO load a numbered game
    }

    public void sound(){
        //TODO sound options
    }

    public void undo(){
        //TODO undo last move
    }

    public void rules(){
        //TODO game rules
    }

    public static void main(String[] args){
        new MahJong();
    }
}
