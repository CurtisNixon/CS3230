/**
 * Created by Curtis on 9/28/2016.
 */
public class CharacterTile extends Tile{
    protected char symbol;
    public CharacterTile(char symbol){
        this.symbol = symbol;
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
}
