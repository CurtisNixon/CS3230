import	java.util.*;
import	java.awt.*;
import	javax.swing.*;


public class MatchesPane extends JScrollPane
{

    private	JPanel[]	discard = new JPanel[2];
    private		int		width = 75;
    private		int		height = 75;
    private		int		count = 0;


    public MatchesPane()
    {
        setPreferredSize(new Dimension(((count+2) * width) + 20, 2 * height + 33));
        setBorder(BorderFactory.createRaisedBevelBorder());

        discard[0] = new JPanel(new GridLayout());
        discard[1] = new JPanel(new GridLayout());
        discard[0].setPreferredSize(new Dimension(0, height));
        discard[1].setPreferredSize(new Dimension(0, height));

        setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel	panel = new JPanel(new BorderLayout());
        setViewportView(panel);

        panel.add(discard[0], BorderLayout.NORTH);
        panel.add(discard[1], BorderLayout.SOUTH);

        discard[0].setBackground(new Color(254, 205, 33));
        discard[1].setBackground(new Color(254, 205, 33));
        panel.setBackground(new Color(254, 205, 33));
    }

    public void clearMatches(){
        discard[0].removeAll();
        discard[0].revalidate();
        discard[0].repaint();
        discard[1].removeAll();
        discard[1].revalidate();
        discard[1].repaint();
    }

    public void addToUndo()
    {

        Dimension	size = new Dimension(++count * width, height + 6);
        discard[0].setPreferredSize(size);
        discard[1].setPreferredSize(size);

        // This version puts the most recently added tiles on the right and scrolls
        // a scroll pane so that the most recently added tiles are visible.
        Stack<Tile> tiles = MahJongBoard.stack;
        for(int i = 0; i < tiles.size(); i+=2){
            discard[0].add(tiles.get(i));
            discard[1].add(tiles.get(i+1));
        }



        Rectangle	r = new Rectangle(count * width, 0, width, height + 6);
        getViewport().scrollRectToVisible(r);


        // This version puts the most recently added tiles on the left - it doesn't
        // need to scroll - the most recently added tiles are always visible.

		/*discard[0].add(t1, 0);
		discard[1].add(t2, 0);*/

        revalidate();
        repaint();
    }


    public static void main(String[] args)
    {
        MatchesPane demo = new MatchesPane();
        JFrame		frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(demo);
        frame.setSize(400, 250);
        frame.setVisible(true);
    }
}
