package dao.exception.insert;

import dao.exception.DAOCannotInsertException;
import domaine.Customer;

/**
 * I am an exception raised if the DAO cannot insert a Customer ino the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class CannotInsertCustomerException extends DAOCannotInsertException {

    /**
     * The customer the DAO tried to insert into the database.
     */
    protected final Customer customer;

    /**
     * I am the constructor of the exception.
     *
     * @param customer the customer the DAO tried to insert into the database.
     */
    public CannotInsertCustomerException(Customer customer) {
        this.customer = customer;
    }

    /**
     * I am a getter to get the customer the DAO tried to add to the database.
     *
     * @return a Customer the DAO tried to add to the database
     */
    public Customer customer() {
        return customer;
    }
}
