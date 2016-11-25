/**
 * Created by Curtis on 10/19/2016.
 */
public class Password extends Lock {
    public String password;
    public Password(String password){
        this.password = password;
    }
    public Password(){
        this.password = null;
    }
    @Override
    public boolean equals(Object otherobject){
        if(!super.equals(otherobject))
            return false;
        Password other = (Password)otherobject;
        return password.equals(other.password);
    }
}
