package domaine.exception;

import domaine.Customer;

/**
 * Created by aurelien on 11/01/2016.
 */
public class DuplicatedCustomerException extends Exception {

    protected Customer customer;

    public DuplicatedCustomerException(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }
}
