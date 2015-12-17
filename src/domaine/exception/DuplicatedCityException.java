package domaine.exception;

import domaine.destination.City;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class DuplicatedCityException extends Exception {

    protected City city;

    public DuplicatedCityException(City category) {
        this.city = city;
    }

    public City getCity() {
        return this.city;
    }

}
