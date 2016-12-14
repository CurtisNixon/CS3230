import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJong extends JFrame {
    private MahJongBoard board;
    private long randomSeed;
    public MahJong(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Mah Jong by Curtis Nixon");
        setSize(1100,700);
        setLayout(null);
        randomSeed = ThreadLocalRandom.current().nextInt(1,100000);
        board = new MahJongBoard(randomSeed);
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
        Object[] options = {"Yes","No"};
        int n = JOptionPane.showOptionDialog(this,"Are you sure you want to start a new game?","New game",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, options,options[1]);
        if(n == JOptionPane.YES_OPTION) {
            randomSeed = ThreadLocalRandom.current().nextInt(1,100000);
            remove(board);
            board = new MahJongBoard(randomSeed);
            add(board);
            repaint();
        }
    }

    public void restart(){
        Object[] options = {"Yes","No"};
        int n = JOptionPane.showOptionDialog(this,"Are you sure you want to restart the current game?","Restart game",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, options,options[1]);
        if(n == JOptionPane.YES_OPTION) {
            remove(board);
            board = new MahJongBoard(randomSeed);
            add(board);
            repaint();
        }
    }

    public void numbered(){
        String string = JOptionPane.showInputDialog(this, "Enter a number between 1 and 100,000.","Numbered Game", JOptionPane.PLAIN_MESSAGE);
        long inputNumber = -1;
        if(string.matches("[0-9]+") && string.length() > 0 && string.length() < 100000){
            inputNumber = Long.parseLong(string);
        }else{
            JOptionPane.showMessageDialog(this, "Invalid input. Enter a number between 1 and 100,000.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(inputNumber < 100000 && inputNumber > 0) {
            remove(board);
            randomSeed = inputNumber;
            board = new MahJongBoard(inputNumber);
            add(board);
            repaint();
        }else{
            JOptionPane.showMessageDialog(this, "Invalid input. Enter a number between 1 and 100,000.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
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
