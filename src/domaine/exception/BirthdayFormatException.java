package domaine.exception;

/**
 * Created by aurelien on 13/01/2016.
 */
public class BirthdayFormatException extends Exception {
    protected String err;

    public BirthdayFormatException(String err){
        this.err = err;
    }

    public String err(){
        return err;
    }
}
