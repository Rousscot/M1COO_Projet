package dao.exception.delete;

import dao.exception.DAODeleteException;
import domaine.Customer;

/**
 * I am an exception raised if the deletion of a Customer into the database fail.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class CustomerDeleteException extends DAODeleteException {

    /**
     * I am the customer that the DAO tried to delete.
     */
    protected final Customer customer;

    /**
     * I am the constructor.
     *
     * @param customer is the customer I tried to delete.
     */
    public CustomerDeleteException(Customer customer) {
        this.customer = customer;
    }

    /**
     * I return the customer that the DAO tried to delete.
     *
     * @return the customer the DAO tried to delete.
     */
    public Customer customer() {
        return customer;
    }
}
