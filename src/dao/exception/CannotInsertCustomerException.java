package dao.exception;

import domaine.Customer;

/**
 * TODO
 */
public class CannotInsertCustomerException extends DAOCannotInsertException {

    protected final Customer customer;


    public CannotInsertCustomerException(Customer customer) {
        this.customer = customer;
    }

    public Customer customer() {
        return customer;
    }
}
