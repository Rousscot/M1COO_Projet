package factory;

import dao.exception.DAOException;
import domaine.Customer;
import domaine.Fly;
import domaine.destination.City;

import java.sql.SQLException;
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

    public List<City> getCities() throws DAOException {
        //TODO map DAO
        if(cities == null){
            cities = null; throw new DAOException(); //TODO remove this null And use dao.allCities();
        }
        return cities;
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        //TODO BDD
    }

    public void deleteCustomer(Customer customer){
        customers.remove(customer);
        //TODO BDD
    }

    public void createAndAddCustomer(String firstName, String lastName, LocalDate birthday, City city){
        Customer customer = new Customer(firstName, lastName, birthday, city);
        addCustomer(customer);
    }


    public City cityAt(int index) throws DAOException {
        return getCities().get(index);
    }

    public int numberOfCities() throws DAOException {
        return getCities().size();
    }
}
