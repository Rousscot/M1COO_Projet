package domaine.Destination;

import java.util.HashSet;
import java.util.Set;

/**
 * I am a class that describe a Hotel.
 *
 * rooms: is a list of all my rooms.
 *
 * @author Cyril Ferlicot & Aurelien Rousseau
 */
public class Hotel {

    protected Set<Room> rooms;

    public Hotel(){
        this.rooms = new HashSet<Room>();
    }
}
