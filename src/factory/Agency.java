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
    protected CustomerDAO daoCustomer;

    public Agency() {
        daoCity = new CityDAO();
        daoFly = new FlyDAO();
        daoCustomer = new CustomerDAO();
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

    public List<Customer> getCustomers() throws DAOException {
        if (customers == null) {
            customers = daoCustomer.allCustomers();
        }
        return customers;
    }

    public void addCustomer(Customer customer) throws DAOException, DuplicatedCustomerException {
        getCustomers().add(customer);
    }

    public void deleteCustomer(Customer customer) throws DAOException, CustomerNotFoundException {
        if (!getCustomers().contains(customer)) {
            throw new CustomerNotFoundException(customer);
        }
        daoCustomer.delete(customer);
        getCustomers().remove(customer);
    }

    public void updateCustomer(Customer customerBefore, Customer customerAfter) throws DAOException {
        if (!customerBefore.getFirstName().equals(customerAfter.getFirstName()) && !customerAfter.getFirstName().equals("")) {
            //TODO update firstname of the customer
            System.out.println("prénom modifié");
        }
        if (!customerBefore.getLastName().equals(customerAfter.getLastName()) && !customerAfter.getFirstName().equals("")) {
            //TODO update lasttname of the customer
            System.out.println("nom modifié");
        }
        if (!customerBefore.getCity().getName().trim().equals(customerAfter.getCity().getName().trim())) {
            //TODO update the city of the customer
            System.out.println("city modifiée");
        }
        LocalDate bDayBefore = customerBefore.getBirthday();
        LocalDate bDayAfter = customerAfter.getBirthday();
        if (bDayBefore.getDayOfMonth() != bDayAfter.getDayOfMonth() || bDayBefore.getMonthValue() != bDayAfter.getMonthValue() || bDayBefore.getYear() != bDayAfter.getYear()   ) {
            //TODO update the birthday of the customer
            System.out.println("Birthday modifié");
        }

    }

    public void createAndAddCustomer(String firstName, String lastName, LocalDate birthday, City city) throws DuplicatedCustomerException, DAOException {
        Customer customer = new Customer(firstName, lastName, birthday, city);
        if (getCustomers().contains(customer)) {
            throw new DuplicatedCustomerException(customer);
        }
        addCustomer(daoCustomer.create(customer));
    }

    public City cityAt(int index) throws DAOException {
        return getCities().get(index);
    }

    public int numberOfCities() throws DAOException {
        return getCities().size();
    }

    public void createAndAddCity(String name) throws DAOException, DuplicatedCityException {
        City city = new City(name);
        if (getCities().contains(city)) {
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

    public void createAndAddFly(City origin, City destination, DayOfWeek day, LocalTime hour, Integer duration, Integer firstTimeCapacity, Integer firstClassPrice, Integer secondClassCapacity, Integer secondClassPrice, Integer daysOfResignation) throws DAOException, DuplicatedFlyException {
        Fly fly = new Fly(origin, destination, day, hour, duration, firstTimeCapacity, firstClassPrice, secondClassCapacity, secondClassPrice, daysOfResignation);
        if (getFlies().contains(fly)) {
            throw new DuplicatedFlyException(fly);
        }
        addFly(daoFly.create(fly));
    }

    public void addFly(Fly fly) throws DAOException {
        getFlies().add(fly);
    }

    public void deleteFly(Fly fly) throws DAOException, FlyNotFoundException {
        if (!getFlies().contains(fly)) {
            throw new FlyNotFoundException(fly);
        }
        daoFly.delete(fly);
        getFlies().remove(fly);
    }

    public int numberOfCustomers() throws DAOException {
        return getCustomers().size();
    }

    public Customer customerAt(int index) throws DAOException {
        return getCustomers().get(index);
    }


}
