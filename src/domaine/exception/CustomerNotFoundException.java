package domaine.exception;

import domaine.Customer;

/**
 * Created by aurelien on 11/01/2016.
 *
 * // TODO doc
 */
public class CustomerNotFoundException extends Exception {
    protected final Customer customer;

    public CustomerNotFoundException(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
