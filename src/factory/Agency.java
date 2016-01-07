package factory;

import dao.exception.DAOException;
import dao.implement.CityDAO;
import dao.implement.FlyDAO;
import domaine.Customer;
import domaine.Fly;
import domaine.destination.City;
import domaine.exception.CityNotFoundException;
import domaine.exception.DuplicatedCityException;
import domaine.exception.DuplicatedHotelException;

import java.time.LocalDate;
import java.util.List;

/**
 * I am a class that manage an agency.
 * This project could not have an Agency but with this class we can easily expand our application.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Agency {

    //protected Planning planning;
    protected List<Customer> customers;
    protected List<City> cities;
    protected List<Fly> flies;
    //protected List<Booking> bookings;
    protected CityDAO daoCity;
    protected FlyDAO daoFly;

    public Agency() {
        daoCity = new CityDAO();
        daoFly = new FlyDAO();
    }

    public List<City> getCities() throws DAOException {
        if (cities == null) {
            cities = daoCity.allCities();
        }
        return cities;
    }

    public List<Fly> getFlies() throws DAOException {
        if (flies == null) {
            flies = daoFly.allFlies();
        }
        return flies;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        //TODO BDD
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
        //TODO BDD
    }

    public void createAndAddCustomer(String firstName, String lastName, LocalDate birthday, City city) {
        Customer customer = new Customer(firstName, lastName, birthday, city);
        addCustomer(customer);
    }

    public City cityAt(int index) throws DAOException {
        return getCities().get(index);
    }

    public int numberOfCities() throws DAOException {
        return getCities().size();
    }

    public void createAndAddCity(String name) throws DAOException, DuplicatedCityException {
        City city = new City(name);
        if(getCities().contains(city)){
            throw new DuplicatedCityException(city);
        }
        addCity(daoCity.create(city));
    }

    public void addCity(City city) throws DAOException {
        getCities().add(city);
    }

    public void deleteCity(City city) throws DAOException, CityNotFoundException {
        if (!getCities().contains(city)) {
            throw new CityNotFoundException(city);
        }
        daoCity.delete(city);
        getCities().remove(city);
    }

    public Fly flyAt(int index) throws DAOException {
        return getFlies().get(index);
    }

    public int numberOfFlies() throws DAOException {
        return getFlies().size();
    }
}
