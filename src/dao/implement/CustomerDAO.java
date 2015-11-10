package dao.implement;

import dao.DAO;
import dao.exception.CannotInsertCustomerException;
import dao.exception.CustomerNotFoundException;
import domaine.Customer;
import domaine.destination.City;

import java.sql.*;
import java.time.ZoneId;

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
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery("SELECT * FROM \"Customer\" WHERE cust_id = " + id);
            if (result.first()) {
                return new Customer(id, result.getString("first_name"), result.getString("last_name"), result.getDate("birthday").toLocalDate(),/* result.getString("city")*/ new City("Foo")); //TODO replace by the real city latter :)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new CustomerNotFoundException(id);
    }
}
