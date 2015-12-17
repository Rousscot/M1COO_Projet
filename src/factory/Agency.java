package factory;

import dao.exception.DAOException;
import dao.implement.CityDAO;
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

    public Agency() {
        daoCity = new CityDAO();
    }

    public List<City> getCities() throws DAOException {
        if (cities == null) {
            cities = daoCity.allCities();
        }
        return cities;
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
        //TODO check if when we get a Duplicated exception this add the city to the database. If yes, throw the exception before we add it.
        addCity(daoCity.create(new City(name)));
    }

    public void addCity(City city) throws DAOException, DuplicatedCityException {
            if(getCities().contains(city)){
                throw new DuplicatedCityException(city);
            }
            getCities().add(city);
    }

    public void deleteCity(City city) throws DAOException, CityNotFoundException {
        if (!getCities().contains(city)) {
            throw new CityNotFoundException(city);
        }
        daoCity.delete(city);
        getCities().remove(city);
    }
}
