package domaine;

import domaine.destination.City;

import java.time.LocalDate;
import java.time.Period;

/**
 * I am a class that describe a customer.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Customer implements DAOSerializable {

    protected Long id;
    protected String firstName;
    protected String lastName;
    protected LocalDate birthday;
    protected City city;

    public Customer(Long id, String firstName, String lastName, LocalDate birthday, City city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.city = city;
    }

    public Customer( String firstName, String lastName, LocalDate birthday, City city) {
       this(0L, firstName, lastName, birthday, city);
    }

    /**
     * TODO
     * @return
     */
    public Integer age() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName ;
    }


    //GETTERS AND SETTERS FOR DAO.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
