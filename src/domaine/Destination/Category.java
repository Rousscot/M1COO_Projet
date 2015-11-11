package domaine.destination;

import java.util.HashSet;
import java.util.Set;

/**
 * I am a class that describe a Category.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Category {

    protected Set<Room> rooms;

    public Category(){
        this.rooms = new HashSet<>();
    }
}

