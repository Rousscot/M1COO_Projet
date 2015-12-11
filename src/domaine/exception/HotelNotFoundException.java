package domaine.exception;

import domaine.destination.Hotel;

/**
 * I am an exception raised when a Hotel is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class HotelNotFoundException extends Exception {

    /**
     * The hotel not found.
     */
    protected final Hotel hotel;

    /**
     * I am the constructor of the exception.
     *
     * @param hotel the hotel needed to find.
     */
    public HotelNotFoundException(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the hotel of the object that the DAO wanted to find.
     */
    public Hotel getHotel() {
        return hotel;
    }

}
