package dao.implement;

import dao.DAO;
import dao.exception.CannotInsertCustomerException;
import dao.exception.CustomerNotFoundException;
import domaine.Customer;

import java.sql.*;

/**
 * TODO
 */
public class CustomerDAO extends DAO<Customer> {

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Customer create(Customer customer) throws CannotInsertCustomerException {
        try {
            String idRequest = "SELECT NEXTVAL('customer_id_seq') AS id";
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO \"Customer\" (cust_id, first_name, last_name, birthday , city) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, customer.firstName());
                prepare.setString(3, customer.lastName());
                prepare.setDate(4, Date.valueOf(customer.birthday()));
                prepare.setString(5, customer.city().toString()); //TODO switch to city latter.
                prepare.executeUpdate();
                customer = this.find(id);
            }
        } catch (SQLException e) {
            throw new CannotInsertCustomerException(customer);
        }
        return customer;
    }

    @Override
    public void delete(Customer obj) {
        //TODO
    }

    @Override
    public Customer update(Customer obj) {
        //TODO
        return null;
    }

    @Override
    public Customer find(Long id) throws CustomerNotFoundException {
        //TODO
        return null;
    }
}
