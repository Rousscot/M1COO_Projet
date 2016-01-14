package factory;

import dao.exception.DAOException;
import dao.implement.CityDAO;
import dao.implement.CustomerDAO;
import dao.implement.FlyDAO;
import domaine.Customer;
import domaine.Fly;
import domaine.destination.City;
import domaine.exception.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * I am a class that manage an agency.
 * This project could not have an Agency but with this class we can easily expand our application.
 * <p>
 * I keep a list of customers, flies, and cities.
 * <p>
 * I should also keep some booking but we did not finished it.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Agency {

    /**
     * The customers I manage.
     */
    protected List<Customer> customers;

    /**
     * The cities managed by me.
     */
    protected List<City> cities;

    /**
     * The flies I manage.
     */
    protected List<Fly> flies;

    /**
     * I should manage some booking.
     */
    //protected List<Booking> bookings;

    /**
     * I keep an instance of the DAO to not recreate it too much.
     */
    protected CityDAO daoCity;

    /**
     * I keep an instance of the DAO to not recreate it too much.
     */
    protected FlyDAO daoFly;

    /**
     * I keep an instance of the DAO to not recreate it too much.
     */
    protected CustomerDAO daoCustomer;

    public Agency() {
        daoCity = new CityDAO();
        daoFly = new FlyDAO();
        daoCustomer = new CustomerDAO();
    }

    /**
     * I am a getter of the cities.
     * I use a lazy initialisation so I can fail if there is a problem with the DAO.
     *
     * @return the list of cities I manage.
     * @throws DAOException raise if there is a problem with the DAO.
     */
    public List<City> getCities() throws DAOException {
        if (cities == null) {
            cities = daoCity.allCities();
        }
        return cities;
    }

    /**
     * I am a getter of the flies.
     * I use a lazy initialisation so I can fail if there is a problem with the DAO.
     *
     * @return the list of flies I manage.
     * @throws DAOException DAOException raise if there is a problem with the DAO.
     */
    public List<Fly> getFlies() throws DAOException {
        if (flies == null) {
            flies = daoFly.allFlies();
        }
        return flies;
    }

    /**
     * I am a getter of the customers.
     * I use a lazy initialisation so I can fail if there is a problem with the DAO.
     *
     * @return the list of customers I manage.
     * @throws DAOException raise if there is a problem with the DAO.
     */
    public List<Customer> getCustomers() throws DAOException {
        if (customers == null) {
            customers = daoCustomer.allCustomers();
        }
        return customers;
    }

    /**
     * I am a method to add a Customer the my list of customer.
     *
     * @param customer the customer to add.
     * @throws DAOException if I cannot get my list of customers during the lazy initialisation.
     */
    public void addCustomer(Customer customer) throws DAOException {
        getCustomers().add(customer);
    }

    /**
     * I am a method to create and add a customer.
     *
     * @param firstName the first name of the customer.
     * @param lastName  the last name of the customer.
     * @param birthday  the birthday date of the customer.
     * @param city      the city of the customer.
     * @throws DAOException                raised if there is a problem with the DAO.
     * @throws DuplicatedCustomerException raised if there is already this city.
     */
    public void createAndAddCustomer(String firstName, String lastName, LocalDate birthday, City city) throws DuplicatedCustomerException, DAOException {
        Customer customer = new Customer(firstName, lastName, birthday, city);
        if (getCustomers().contains(customer)) {
            throw new DuplicatedCustomerException(customer);
        }
        addCustomer(daoCustomer.create(customer));
    }

    /**
     * I delete a customer.
     *
     * @param customer the customer to delete.
     * @throws DAOException              raised if there is a problem with the DAO.
     * @throws CustomerNotFoundException raised if the customer is not in the list of customers I manage.
     */
    public void deleteCustomer(Customer customer) throws DAOException, CustomerNotFoundException {
        if (!getCustomers().contains(customer)) {
            throw new CustomerNotFoundException(customer);
        }
        daoCustomer.delete(customer);
        getCustomers().remove(customer);
    }

    /**
     * Return the city for an index in order to help with a list creation.
     *
     * @param index the index of the city
     * @return a city for this index.
     * @throws DAOException raised if there is a problem with the DAO.
     */
    public City cityAt(int index) throws DAOException {
        return getCities().get(index);
    }

    /**
     * Return the number of cities I manage.
     *
     * @return the number of cities I manage.
     * @throws DAOException raised if there is a problem with the DAO.
     */
    public int numberOfCities() throws DAOException {
        return getCities().size();
    }

    /**
     * I am a method to add a City the my list of city.
     *
     * @param city the city to add.
     * @throws DAOException if I cannot get my list of cities during the lazy initialisation.
     */
    public void addCity(City city) throws DAOException {
        getCities().add(city);
    }

    /**
     * I am a method to create and add a city.
     *
     * @param name the name of the City.
     * @throws DAOException            raised if there is a problem with the DAO.
     * @throws DuplicatedCityException raised if there is already this city.
     */
    public void createAndAddCity(String name) throws DAOException, DuplicatedCityException {
        City city = new City(name);
        if (getCities().contains(city)) {
            throw new DuplicatedCityException(city);
        }
        addCity(daoCity.create(city));
    }

    /**
     * I delete a city.
     *
     * @param city the city to delete.
     * @throws DAOException          raised if there is a problem with the DAO.
     * @throws CityNotFoundException raised if the city is not in the list of city I manage.
     */
    public void deleteCity(City city) throws DAOException, CityNotFoundException {
        if (!getCities().contains(city)) {
            throw new CityNotFoundException(city);
        }
        daoCity.delete(city);
        getCities().remove(city);
    }

    /**
     * Return the fly for an index in order to help with a list creation.
     *
     * @param index the index of the fly
     * @return a fly for this index.
     * @throws DAOException raised if there is a problem with the DAO.
     */
    public Fly flyAt(int index) throws DAOException {
        return getFlies().get(index);
    }

    /**
     * Return the number of flies I manage.
     *
     * @return the number of flies I manage.
     * @throws DAOException raised if there is a problem with the DAO.
     */
    public int numberOfFlies() throws DAOException {
        return getFlies().size();
    }

    /**
     * I am a method to add a Fly the my list of fly.
     *
     * @param fly the fly to add.
     * @throws DAOException if I cannot get my list of flies during the lazy initialisation.
     */
    public void addFly(Fly fly) throws DAOException {
        getFlies().add(fly);
    }

    /**
     * I am a method to create and add a Fly.
     *
     * @param origin              the city of origin of the fly.
     * @param destination         the city of destination of the fly.
     * @param day                 the day of the fly.
     * @param hour                the hour of the fly.
     * @param duration            the duration of the fly.
     * @param firstTimeCapacity   the capacity of the first class.
     * @param firstClassPrice     the price of a first class seat.
     * @param secondClassCapacity the capacity of the second.
     * @param secondClassPrice    the price of a second class seat.
     * @param daysOfResignation   the number of days of resignation.
     * @throws DAOException           raised if there is a problem with the DAO.
     * @throws DuplicatedFlyException raised if there is already this fly.
     */
    public void createAndAddFly(City origin, City destination, DayOfWeek day, LocalTime hour, Integer duration, Integer firstTimeCapacity, Integer firstClassPrice, Integer secondClassCapacity, Integer secondClassPrice, Integer daysOfResignation) throws DAOException, DuplicatedFlyException {
        Fly fly = new Fly(origin, destination, day, hour, duration, firstTimeCapacity, firstClassPrice, secondClassCapacity, secondClassPrice, daysOfResignation);
        if (getFlies().contains(fly)) {
            throw new DuplicatedFlyException(fly);
        }
        addFly(daoFly.create(fly));
    }

    /**
     * I delete a fly.
     *
     * @param fly the fly to delete.
     * @throws DAOException         raised if there is a problem with the DAO.
     * @throws FlyNotFoundException raised if the fly is not in the list of fly I manage.
     */
    public void deleteFly(Fly fly) throws DAOException, FlyNotFoundException {
        if (!getFlies().contains(fly)) {
            throw new FlyNotFoundException(fly);
        }
        daoFly.delete(fly);
        getFlies().remove(fly);
    }

    /**
     * Return the number of customers I manage.
     *
     * @return the number of customers I manage.
     * @throws DAOException raised if there is a problem with the DAO.
     */
    public int numberOfCustomers() throws DAOException {
        return getCustomers().size();
    }

    /**
     * Return the customer for an index in order to help with a list creation.
     *
     * @param index the index of the fly
     * @return a customer for this index.
     * @throws DAOException raised if there is a problem with the DAO.
     */
    public Customer customerAt(int index) throws DAOException {
        return getCustomers().get(index);
    }

}
