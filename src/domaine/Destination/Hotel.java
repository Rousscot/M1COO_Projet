package domaine.destination;

import java.util.ArrayList;
import java.util.List;

/**
 * I am a class that describe a Hotel.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Hotel {

    protected List<Category> categories;

    public Hotel(){
        this.categories = new ArrayList<>();
    }
}
