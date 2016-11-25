/**
 * Created by Curtis on 10/19/2016.
 */
public class Double extends Password {
    private int pin;
    private String password;
    public Double(int pin, String password){
        this.pin = pin;
        super.password = password;
    }
    @Override
    public boolean equals(Object otherobject){
        if(!super.equals(otherobject))
            return false;
        Double other = (Double) otherobject;
        return (pin == other.pin && password == other.password);
    }
}
