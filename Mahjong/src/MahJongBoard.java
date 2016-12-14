import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJongBoard extends JPanel implements MouseListener {

    private static int xBounds = 73;
    private static int yBounds = 73;
    private static int xLength = 56;
    private static int yLength = 56;
    private MahJongModel model;
    private Tile firstClickedTile = null;
    private int firstClickedTileX;
    private int firstClickedTileY;
    private int firstClickedTileZ;
    private int firstClickedTileZOrder;
    private Tile secondClickedTile = null;
    private int secondClickedTileX;
    private int secondClickedTileY;
    private int secondClickedTileZ;
    private int secondClickedTileZOrder;

    public MahJongBoard(){
        setLayout(null);
        setBackground(Color.ORANGE);
        setLocation(0,0);
        setSize(1100,700);
        model = new MahJongModel();

        //top tile
        Tile t = model.topTile;
        t.addMouseListener(this);
        t.setBounds(490,225, xBounds, yBounds);
        add(t);

        //left most tile
        t = model.leftMostTile;
        t.addMouseListener(this);
        t.setBounds(64,285,xBounds, yBounds);
        add(t);

        int xPosition = 144;
        int yPosition = -42;
        for(int z = 4; z >= 0; z--) {
            xPosition = xPosition - 16;
            yPosition = yPosition + 16;
            for (int i = 9; i >= 0; i--) {
                for (int j = 1; j < 13; j++) {
                    if (model.tiles[i][j][z] != null) {
                        t = model.tiles[i][j][z];
                        t.setBounds(xPosition + j * xLength, yPosition + i * yLength, xBounds, yBounds);
                        t.addMouseListener(this);
                        add(t);
                    }
                }
            }
        }

        //right most tiles
        t = model.rightTileLeft;
        t.addMouseListener(this);
        t.setBounds(792, 285, xBounds, yBounds);
        add(t);

        t = model.rightTileRight;
        t.addMouseListener(this);
        t.setBounds(792 + xLength, 285, xBounds, yBounds);
        add(t);


        setVisible(true);
    }

    public void mouseClicked(MouseEvent e){
        System.out.println(e.getSource() + " was clicked");
        Tile clickedTile = (Tile)e.getSource();
        int tileX = clickedTile.xPosition;
        int tileY = clickedTile.yPosition;
        int tileZ = clickedTile.zPosition;
        boolean tileIsOpen = tileIsOpen(clickedTile, tileX, tileY, tileZ);
        //valid click on an open tile
        if(tileIsOpen){
            if(firstClickedTile == null){
                System.out.println("set first click: " + clickedTile);
                clickedTile.highlightTile = true;
                firstClickedTile = clickedTile;
                firstClickedTileX = tileX;
                firstClickedTileY = tileY;
                firstClickedTileZ = tileZ;
                //firstClickedTileZOrder = tileZOrder;
            }else if(secondClickedTile == null){
                System.out.println("set second click: " + clickedTile);
                clickedTile.highlightTile = true;
                repaint();
                secondClickedTile = clickedTile;
                secondClickedTileX = tileX;
                secondClickedTileY = tileY;
                secondClickedTileZ = tileZ;
//                secondClickedTileZOrder = tileZOrder;
            }
            if(firstClickedTile != null && secondClickedTile != null){
                if(firstClickedTile != secondClickedTile) {
                    if (firstClickedTile.matches(secondClickedTile)) {
                        System.out.println("remove: " + firstClickedTile);
                        System.out.println("remove: " + secondClickedTile);
                        removeTile(firstClickedTile, firstClickedTileX, firstClickedTileY, firstClickedTileZ);
                        removeTile(secondClickedTile, secondClickedTileX, secondClickedTileY, secondClickedTileZ);
                        revalidate();
                        repaint();
                    }
                }
                firstClickedTile.highlightTile = false;
                secondClickedTile.highlightTile = false;
                firstClickedTile = null;
                secondClickedTile = null;

            }
        }
        //tile is not open
        else{
            if(firstClickedTile != null){
                firstClickedTile.highlightTile = false;
            }
            if(secondClickedTile != null) {
                secondClickedTile.highlightTile = false;
            }
            firstClickedTile = null;
            secondClickedTile = null;
        }
        repaint();
    }
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mousePressed(MouseEvent e){}

    public boolean tileIsOpen(Tile clickedTile, int tileX, int tileY, int tileZ){
        //check if it is a special case tile
        if(clickedTile.equals(model.topTile)) {
            System.out.println("toptile");
            return true;
        }else if(clickedTile.equals(model.leftMostTile)){
            System.out.println("left special tile");
            return true;
        }else if(clickedTile.equals(model.rightTileLeft)){
            System.out.println("right tile left");
            System.out.println("right tile removed: " + model.rightTileRightRemoved);
            if(model.rightTileRightRemoved){
                //TODO
                return true;
            }
        }else if(clickedTile.equals(model.rightTileRight)){
            System.out.println("right tile right");
            return true;
        }
        //adjacent to left tile
        else if((tileX == 4 && tileY == 1 && tileZ == 0) || (tileX == 5 && tileY == 1 && tileZ == 0)) {
            System.out.println("adjacent to left tile");
            System.out.println("left tile removed: " + model.leftMostTileRemoved);
            if(model.leftMostTileRemoved){
                System.out.println("removing tile.");
                return true;
            }
        }
        //adjacent to the right most left tile
        else if((tileX == 4 && tileY == 12 && tileZ == 0) || (tileX == 5 && tileY == 12 && tileZ == 0)){
            System.out.println("adjacent to right most left tile");
            if (model.rightTileLeftRemoved) {
                return true;
            }
        }
        //below top tile
        else if((tileX == 5 && tileY == 6 && tileZ == 3) || (tileX == 4 && tileY == 6 && tileZ == 3) || (tileX == 4 && tileY == 7 && tileZ == 3) || (tileX == 5 && tileY == 7 && tileZ == 3)){
            if(model.topTileRemoved){
                return true;
            }
        }
        else{
            //check left and right sides
            System.out.println("tilex: " + tileX + " tiley: " + tileY + " tilez: " + tileZ);
            System.out.println("left tile: " + model.tiles[tileX][(tileY - 1)][tileZ]);
            System.out.println("right tile: " + model.tiles[tileX][(tileY + 1)][tileZ]);
            if (model.tiles[tileX][(tileY - 1)][tileZ] == null || model.tiles[tileX][(tileY + 1)][tileZ] == null) {
                //check if a tile is on top of this tile
                if (model.tiles[tileX][tileY][(tileZ + 1)] == null) {
                    System.out.println(clickedTile + " is open");
                    return true;
                }
            }
        }
        return false;
    }

    public void removeTile(Tile t, int tileX, int tileY, int tileZ){
        if(t.equals(model.topTile)) {
            System.out.println("remove toptile");

            //TODO
            model.topTileRemoved = true;
        }else if(t.equals(model.leftMostTile)){
            System.out.println("left special tile");

            //TODO add to array
            model.leftMostTileRemoved = true;
        }else if(t.equals(model.rightTileLeft)){
            System.out.println("right tile left");
            System.out.println("right tile removed: " + model.rightTileRightRemoved);
            if(model.rightTileRightRemoved){
                //TODO
                model.rightTileLeftRemoved = true;
            }
        }else if(t.equals(model.rightTileRight)){
            System.out.println("right tile right");
            //TODO
            model.rightTileRightRemoved = true;
        }
        //adjacent to left tile
        else if((tileX == 4 && tileY == 1 && tileZ == 0) || (tileX == 5 && tileY == 1 && tileZ == 0)) {
            System.out.println("adjacent to left tile");
            System.out.println("left tile removed: " + model.leftMostTileRemoved);
            if(model.leftMostTileRemoved){
                System.out.println("removing tile.");
                //TODO add to an array for tracking

                //remove tile from tile model
                model.tiles[tileX][tileY][tileZ] = null;
            }
        }
        //adjacent to the right most left tile
        else if((tileX == 4 && tileY == 12 && tileZ == 0) || (tileX == 5 && tileY == 12 && tileZ == 0)){
            System.out.println("adjacent to right most left tile");
            if (model.rightTileLeftRemoved) {
                //TODO add to an array for tracking

                //remove tile from tile model
                model.tiles[tileX][tileY][tileZ] = null;
            }
        }
        //below top tile
        else if((tileX == 5 && tileY == 6 && tileZ == 3) || (tileX == 4 && tileY == 6 && tileZ == 3) || (tileX == 4 && tileY == 7 && tileZ == 3) || (tileX == 5 && tileY == 7 && tileZ == 3)){
            if(model.topTileRemoved){
                //TODO add to an array for tracking

                //remove tile from tile model
                model.tiles[tileX][tileY][tileZ] = null;
            }
        }
        else{
            //check left and right sides
            System.out.println("tilex: " + tileX + " tiley: " + tileY + " tilez: " + tileZ);
            System.out.println("left tile: " + model.tiles[tileX][(tileY - 1)][tileZ]);
            System.out.println("right tile: " + model.tiles[tileX][(tileY + 1)][tileZ]);
            if (model.tiles[tileX][(tileY - 1)][tileZ] == null || model.tiles[tileX][(tileY + 1)][tileZ] == null) {
                System.out.println("passed left right check");
                //check if a tile is on top of this tile
                if (model.tiles[tileX][tileY][(tileZ + 1)] == null) {
                    System.out.println("passed on top of check, removing.");
                    //TODO add to an array for tracking

                    //remove tile from tile model
                    model.tiles[tileX][tileY][tileZ] = null;
                }
            }
        }
        //remove the tile from the JPanel
        remove(t);
    }

    ImageIcon img = new ImageIcon(getClass().getResource("images/dragon_bg.png"));
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image image = img.getImage().getScaledInstance(1100,700,Image.SCALE_SMOOTH);
        g.drawImage(new ImageIcon(image).getImage(),0,0,this);

    }



}
