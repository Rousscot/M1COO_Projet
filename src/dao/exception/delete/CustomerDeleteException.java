package dao.exception.delete;

import dao.exception.DAODeleteException;
import domaine.Customer;

/**
 * TODO
 */
public class CustomerDeleteException extends DAODeleteException {

    protected final Customer customer;

    public CustomerDeleteException(Customer customer) {
        this.customer = customer;
    }

    public Customer customer() {
        return customer;
    }
}
