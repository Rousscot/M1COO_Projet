package domaine.destination;

import java.util.HashSet;
import java.util.Set;

/**
 * I am a class that describe a city.
 *
 * hotels: a collection of hotels that are in a city.
 *
 * @author Cyril Ferlicot & Aurelien Rousseau
 */
public class City {

    protected Set<Hotel> hotels;

    public City(){
        this.hotels = new HashSet<Hotel>();
    }

}
