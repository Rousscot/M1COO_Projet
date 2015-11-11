package dao.exception.update;

import dao.exception.DAOUpdateFailedException;
import domaine.Customer;

/**
 * I am an exception raised when the DAO cannot update a Customer into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class CustomerUpdateFailedException extends DAOUpdateFailedException {

    /**
     * The customer the DAO tried to update.
     */
    protected final Customer customer;

    /**
     * I am the constructor.
     *
     * @param customer the customer the DAO tried to update.
     */
    public CustomerUpdateFailedException(Customer customer) {
        this.customer = customer;
    }

    /**
     * I am a getter to get the customer the DAO tried to update.
     *
     * @return the customer the DAO tried to update.
     */
    public Customer customer() {
        return this.customer;
    }
}
