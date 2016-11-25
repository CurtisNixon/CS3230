import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Curtis on 11/25/2016.
 */
public class MahJongModel extends MahJongBoard {
    public ArrayList<Tile> tileList = new ArrayList<Tile>();
    public Tile[][][] tiles = new Tile[9][12][5];
    public Tile leftMostTile;
    public Tile rightTileLeft;
    public Tile rightTileRight;
    public Tile topTile;

    public MahJongModel() {

        //add character tiles to array list
        for (int i = 1; i < 16; i++) {
            char initializer = '1';
            if(i <= 9){
               initializer = Character.forDigit(i,10);
            }else if(i == 10){
                initializer = 'N';
            }else if(i == 11){
                initializer = 'E';
            }else if(i == 12){
                initializer = 'W';
            }else if(i == 13){
                initializer = 'S';
            }else if(i == 14){
                initializer = 'C';
            }else if(i == 15){
                initializer = 'F';
            }
            //4 instances of each tile
            for(int j = 0; j <  4; j++){
                tileList.add(new CharacterTile(initializer));
            }
        }
        //add white dragon tiles to array list
        for(int i = 0; i < 4; i ++ ) {
            //4 tiles
            tileList.add(new WhiteDragonTile());
        }
        //add bamboo tiles to array list
        for(int i = 1; i < 10; i++){
            //4 instances of each tile
            for (int j = 0; j < 4; j++) {
                //create bamboo1tile
                if(i == 1){
                    tileList.add(new Bamboo1Tile());
                }else {
                    tileList.add(new BambooTile(i));
                }
            }

        }
        //add circle tiles to array list
        for(int i = 1; i < 10; i++){
            //4 instances of each tile
            for (int j = 0; j < 4; j++) {
                tileList.add(new CircleTile(i));
            }
        }
        //add flower tiles to array list, 1 of each

        tileList.add(new FlowerTile("Chrysanthemum"));
        tileList.add(new FlowerTile("Orchid"));
        tileList.add(new FlowerTile("Plum"));
        tileList.add(new FlowerTile("Bamboo"));

        //add season tiles to array list, 1 of each
        tileList.add(new SeasonTile("Spring"));
        tileList.add(new SeasonTile("Summer"));
        tileList.add(new SeasonTile("Fall"));
        tileList.add(new SeasonTile("Winter"));

        ArrayList<Tile> randomizedList = new ArrayList<Tile>();
        Random  random = new Random();
        while(tileList.size() > 0){
            Tile t = tileList.remove(random.nextInt(tileList.size()));
            randomizedList.add(t);
        }
        tileList = randomizedList;

        //add tileList to Tile[][][]

        //layer 1
        //row 1 tiles 1-12
        for(int i = 0; i < 12; i++) {
            tiles[0][i][0] = tileList.remove(0);
        }
        //row2 tiles 13-20
        for(int i = 2; i < 10; i++) {
            tiles[1][i][0] = tileList.remove(0);
        }
        //row 3 tiles 21-30
        for(int i = 1; i < 11; i++) {
            tiles[2][i][0] = tileList.remove(0);
        }
        //row 4 tiles 31 - 42
        for(int i = 0; i < 12; i++) {
            tiles[3][i][0] = tileList.remove(0);
        }
        //row 5 tiles 43-54
        for(int i = 0; i < 12; i++) {
            tiles[4][i][0] = tileList.remove(0);
        }
        //row 6 tiles 55-64
        for(int i = 1; i < 11; i++) {
            tiles[5][i][0] = tileList.remove(0);
        }
        //row 7 tiles 65-72
        for(int i = 2; i < 10; i++) {
            tiles[6][i][0] = tileList.remove(0);
        }
        //row 8 tiles 73-84
        for(int i = 0; i < 12; i++) {
            tiles[7][i][0] = tileList.remove(0);
        }
        //layer 2
        //row 1 tiles 85-90
        for(int i = 0; i < 6; i++){
            tiles[1][i+3][1] = tileList.remove(0);
        }
        //row 2 tiles 91-96
        for(int i = 0; i < 6; i++){
            tiles[2][i+3][1] = tileList.remove(0);
        }
        //row 3 tiles 97-102
        for(int i = 0; i < 6; i++){
            tiles[3][i+3][1] = tileList.remove(0);
        }
        //row 4 tiles 103-108
        for(int i = 0; i < 6; i++){
            tiles[4][i+3][1] = tileList.remove(0);
        }
        //row 5 tiles 109-114
        for(int i = 0; i < 6; i++){
            tiles[5][i+3][1] = tileList.remove(0);
        }
        //row 6 tiles 115-120
        for(int i = 0; i < 6; i++){
            tiles[6][i+3][1] = tileList.remove(0);
        }

        //layer 3
        //layer 4
        //layer 5

    }

    public void positionTile(){}

    public static void main(String[] args){
        MahJongModel model = new MahJongModel();
        System.out.println("tilelist size: " + model.tileList.size());
        //tileList
        for(int i = 0; i < model.tileList.size(); i ++){
            System.out.println(model.tileList.get(i).toString());
        }
        System.out.println("---------------------------------------");
        //tiles[row][column][layer]
        for(int k = 0; k < 4; k++) {
            for(int i = 0; i < 8; i ++){
                for(int j = 0; j < 12; j ++){
                    System.out.println(model.tiles[i][j][k]);
                }
                System.out.println(" row : " + i);
            }
            System.out.println("layer: " + k);
        }
    }
}
