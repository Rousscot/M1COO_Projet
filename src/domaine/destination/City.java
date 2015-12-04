package domaine.destination;

import java.util.ArrayList;
import java.util.List;

/**
 * I am a class that describe a city.
 *
 * hotels: a collection of hotels that are in a city.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class City {

    protected List<Hotel> hotels;
    protected String name;
    protected Long id;

    public City(String name){
        this.name = name;
        hotels = new ArrayList<>();
        id = 0L;
    }


    @Override
    public String toString() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
