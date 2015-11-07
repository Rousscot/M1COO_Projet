package dao.implement;

import dao.DAO;
import dao.exception.CustomerNotFoundException;
import domaine.Customer;

import java.sql.Connection;

/**
 * TODO
 */
public class CustomerDAO extends DAO<Customer> {

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Customer obj) {
        //TODO
        return false;
    }

    @Override
    public boolean delete(Customer obj) {
        //TODO
        return false;
    }

    @Override
    public boolean update(Customer obj) {
        //TODO
        return false;
    }

    @Override
    public Customer find(Integer id) throws CustomerNotFoundException {
        //TODO
        return null;
    }
}
