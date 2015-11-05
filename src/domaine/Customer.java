package domaine;

import domaine.Destination.City;

import java.time.LocalDate;
import java.time.Period;

/**
 * I am a class that describe a customer.
 *
 * @author Cyril Ferlicot & Aurelien Rousseau
 */
public class Customer {

    protected String firstName;

    protected String lastName;

    protected LocalDate birthday;

    protected City city;

    public Customer(String firstName, String lastName, LocalDate birthday, City city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.city = city;
    }

    public Integer age() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }


}
