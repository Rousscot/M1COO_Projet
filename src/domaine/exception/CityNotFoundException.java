package domaine.exception;

import domaine.destination.City;

/**
 * I am an exception raised when a City is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class CityNotFoundException extends Exception {

    /**
     * The city not found.
     */
    protected final City city;

    /**
     * I am the constructor of the exception.
     *
     * @param city the city needed to find.
     */
    public CityNotFoundException(City city) {
        this.city = city;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the city of the object that the DAO wanted to find.
     */
    public City getCity() {
        return city;
    }

}
