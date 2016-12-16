import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setSize(1100,740);
        setLayout(null);
        randomSeed = ThreadLocalRandom.current().nextInt(1,100000);
        board = new MahJongBoard(randomSeed);
        add(board);
        makeMenu();
        setVisible(true);

    }

    public static void paintMatches(){
        matchPane.addToUndo();
        matchPane.revalidate();
        matchPane.repaint();
    }

    public static MatchesPane matchPane = new MatchesPane();

    private void showMatches(){
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(matchPane);
        frame.setSize(400, 250);
        frame.setTitle("Matched Tiles");
        frame.setVisible(true);

    }

    private void makeMenu(){
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic('G');
        menuBar.add(gameMenu);

        JMenuItem play = new JMenuItem("Play new game",'P');
        play.setToolTipText("Start a new game");
        play.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
        gameMenu.add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });

        JMenuItem restart = new JMenuItem("Restart Game",'R');
        restart.setToolTipText("Restart the current game");
        restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        gameMenu.add(restart);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restart();
            }
        });

        JMenuItem numbered = new JMenuItem("Numbered Game",'N');
        numbered.setToolTipText("Play a numbered game");
        numbered.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        gameMenu.add(numbered);
        numbered.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numbered();
            }
        });

        JMenuItem matches = new JMenuItem("Tiles Matched",'M');
        matches.setToolTipText("Opens a window with all the matched tiles.");
        matches.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
        gameMenu.add(matches);
        matches.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMatches();
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
            matchPane.clearMatches();
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
            matchPane.clearMatches();
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
            matchPane.clearMatches();
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
        if(MahJongBoard.stack.size() > 0){
            board.undo();
            board.undo();
            revalidate();
            repaint();
        }else{
            JOptionPane.showMessageDialog(this, "No moves to undo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void rules(){
        //TODO game rules
    }

    public static void main(String[] args){
        new MahJong();
    }
}
