package domaine.destination;

import dao.exception.DAOException;
import dao.implement.HotelDAO;
import domaine.DAOSerializable;
import domaine.exception.DuplicatedHotelException;
import domaine.exception.HotelNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * I am a class that describe a city.
 * <p>
 * hotels: a collection of hotels that are in a city.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class City implements DAOSerializable {

    protected List<Hotel> hotels;
    protected String name;
    protected Long id;
    protected HotelDAO dao;

    public City(String name) {
        this(0L, name);
    }

    public City(Long id, String name) {
        this.name = name;
        this.id = id;
        dao = new HotelDAO();
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

    public List<Hotel> getHotels() throws DAOException {
        if(hotels == null){
            hotels = dao.allHotelsForId(getId());
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;

        City city = (City) o;

        return name.equals(city.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Integer numberOfHotels() throws DAOException {
        return getHotels().size();
    }

    public Hotel hotelAt(Integer index) throws DAOException {
        return getHotels().get(index);
    }

    public void addHotel(Hotel hotel) throws DuplicatedHotelException, DAOException {
        if(getHotels().contains(hotel)){
            throw new DuplicatedHotelException(hotel);
        }
        getHotels().add(hotel);
    }

    public void createAndAddHotel(String name, Integer resignationDays) throws DAOException, DuplicatedHotelException {
        //TODO check if when we get a Duplicated exception this add the category to the database. If yes, throw the exception before we add it.
        addHotel(dao.create(new Hotel(name, resignationDays, this)));
    }

    public void deleteHotel(Hotel hotel) throws DAOException, HotelNotFoundException {
        if (!getHotels().contains(hotel)) {
            throw new HotelNotFoundException(hotel);
        }
        dao.delete(hotel);
        getHotels().remove(hotel);
    }

    public void deleteAllHotels() throws HotelNotFoundException, DAOException {
        for (Hotel hotel : getHotels()) {
            deleteHotel(hotel);
        }
    }
}
