package domaine.destination;

import java.util.ArrayList;
import java.util.List;

/**
 * I am a class that describe a Category.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Category {

    protected List<Room> rooms;

    public Category(){
        this.rooms = new ArrayList<>();
    }
}

