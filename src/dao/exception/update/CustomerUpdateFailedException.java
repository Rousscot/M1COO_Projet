package dao.exception.update;

import dao.exception.DAOUpdateFailedException;
import domaine.Customer;

/**
 * TODO
 */
public class CustomerUpdateFailedException extends DAOUpdateFailedException {

    protected final Customer customer;

    public CustomerUpdateFailedException(Customer customer) {
        this.customer = customer;
    }

    public Customer customer() {
        return this.customer;
    }
}
