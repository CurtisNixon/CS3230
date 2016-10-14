import java.awt.*;
import javax.swing.*;
/**
 * Created by Curtis on 9/28/2016.
 */
public class CharacterTile extends Tile{
    protected char symbol;
    public CharacterTile(char symbol){
        this.symbol = symbol;

        setToolTipText(toString());
    }

    public boolean matches(Tile other){
        if (!super.matches(other))
            return false;
        CharacterTile otherObj = (CharacterTile) other;
        return symbol == otherObj.symbol;
    }

    public String toString(){
        String returnString;
        switch(symbol){
            case 'N': returnString = "North Wind";
                break;
            case 'E': returnString = "East Wind";
                break;
            case 'W': returnString = "West Wind";
                break;
            case 'S': returnString = "South Wind";
                break;
            case 'C': returnString = "Red Dragon";
                break;
            case 'F': returnString = "Green Dragon";
                break;
            default: returnString = "Character " + symbol;
        }

        return returnString;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintCharacterTile(g);
    }

    public void paintCharacterTile(Graphics g){
        switch(symbol) {
            //the numbered character tiles
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                drawCharacter(g);
                drawNumber(g);
                drawWan(g);
                break;
            //the wind tiles, red dragon and green dragon
            case 'N':
            case 'E':
            case 'S':
            case 'W':
            case 'C':
            case 'F':
                drawLargeCharacter(g);
                drawNumber(g);
                break;
        }
    }

    public void drawCharacter(Graphics g){
        String characterString="";
        switch(symbol){
            case '1':
                characterString = "\u4E00";
                break;
            case '2':
                characterString = "\u4E8C";
                break;
            case '3':
                characterString = "\u4E09";
                break;
            case '4':
                characterString = "\u56DB";
                break;
            case '5':
                characterString = "\u4E94";
                break;
            case '6':
                characterString = "\u516D";
                break;
            case '7':
                characterString = "\u4E03";
                break;
            case '8':
                characterString = "\u516B";
                break;
            case '9':
                characterString = "\u4E5D";
                break;
        }
        g.setColor(new Color(0, 0, 0));
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 20));
        g.drawString(characterString, 42, 23);
    }

    public void drawWan(Graphics g){
        g.setColor(new Color(247, 27, 7));
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 20));
        g.drawString("\u842C", 42, 48);
    }

    public void drawNumber(Graphics g){
        g.setColor(new Color(247, 27, 7));
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 12));
        g.drawString(Character.toString(symbol), 64, 15);
    }

    public void drawLargeCharacter(Graphics g){
        String characterString = "";
        switch(symbol){
            case 'N':
                characterString = "\u5317";
                break;
            case 'E':
                characterString = "\u6771";
                break;
            case 'S':
                characterString = "\u897F";
                break;
            case 'W':
                characterString = "\u5357";
                break;
            case 'C':
                characterString = "\u4E2D";
                break;
            case 'F':
                characterString = "\u767C";
                break;
        }
        //set color base on the symbol
        if(symbol == 'N' || symbol == 'E' || symbol == 'S' || symbol == 'W'){
            g.setColor(new Color(0, 0, 0));
        }else if(symbol == 'C'){
            g.setColor(new Color(247, 27, 7));
        }else{
            g.setColor(new Color(4, 158, 30));
        }
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 40));
        g.drawString(characterString, 30, 48);

    }

    public static void main(String[] args)
    {
        JFrame		frame = new JFrame();
        JPanel		tiles = new JPanel();
        JScrollPane	scroller = new JScrollPane(tiles);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Character Tiles");
        frame.add(scroller);

        // Try something like this if your tiles don't fit on the screen.
        // Replace "tile width" and "tile height" with your values.
        //scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

        tiles.add(new CharacterTile('1'));
        tiles.add(new CharacterTile('2'));
        tiles.add(new CharacterTile('3'));
        tiles.add(new CharacterTile('4'));
        tiles.add(new CharacterTile('5'));
        tiles.add(new CharacterTile('6'));
        tiles.add(new CharacterTile('7'));
        tiles.add(new CharacterTile('8'));
        tiles.add(new CharacterTile('9'));
        tiles.add(new CharacterTile('N'));
        tiles.add(new CharacterTile('E'));
        tiles.add(new CharacterTile('W'));
        tiles.add(new CharacterTile('S'));
        tiles.add(new CharacterTile('C'));
        tiles.add(new CharacterTile('F'));

        frame.pack();
        frame.setVisible(true);
    }
}
