package domaine.exception;

import domaine.destination.Hotel;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class DuplicatedHotelException extends Exception {

    protected Hotel hotel;

    public DuplicatedHotelException(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return this.hotel;
    }

}
