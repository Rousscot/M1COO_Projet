package domaine;

import domaine.destination.City;

import java.time.LocalDate;
import java.time.Period;

/**
 * I am a class that describe a customer.
 *
 * @author Cyril Ferlicot & Aurelien Rousseau
 */
public class Customer {

    protected final Integer id;

    protected String firstName;

    protected String lastName;

    protected LocalDate birthday;

    protected City city;

    public Customer(Integer id, String firstName, String lastName, LocalDate birthday, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.city = city;
    }

    /**
     * TODO
     * @return
     */
    public Integer age() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }


    //GETTERS AND SETTERS FOR DAO.

    
    public Integer id() {
        return id;
    }

    public String firstName() {
        return firstName;
    }

    public void firstName(String firstName) {
        this.firstName = firstName;
    }

    public String lastName() {
        return lastName;
    }

    public void lastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate birthday() {
        return birthday;
    }

    public void birthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public City city() {
        return city;
    }

    public void city(City city) {
        this.city = city;
    }
}
