package domaine.destination;

import java.util.HashSet;
import java.util.Set;

/**
 * I am a class that describe a Hotel.
 *
 * @author Cyril Ferlicot & Aurelien Rousseau
 */
public class Hotel {

    protected Set<Category> categories;

    public Hotel(){
        this.categories = new HashSet<>();
    }
}
