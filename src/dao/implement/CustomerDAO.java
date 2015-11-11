package dao.implement;

import dao.DAO;
import dao.exception.find.CustomerNotFoundException;
import dao.exception.insert.CannotInsertCustomerException;
import dao.exception.update.CustomerUpdateFailedException;
import domaine.Customer;
import domaine.destination.City;

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
        String idRequest = "SELECT NEXTVAL('customer_id_seq') AS id";
        try {
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
    public Customer update(Customer customer) throws CustomerUpdateFailedException {
        String request = "UPDATE \"Customer\" SET first_name = '" + customer.firstName() + "'," +
                " last_name = '" + customer.lastName() + "'," +
                " birthday = '" + Date.valueOf(customer.birthday()) + "'," +
                " city = '" + customer.city().toString() + "'" + //TODO Use real city!
                " WHERE cust_id = " + customer.id();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            customer = this.find(customer.id());
        } catch (SQLException e) {
            throw new CustomerUpdateFailedException(customer);
        }
        return customer;
    }

    @Override
    public Customer find(Long id) throws CustomerNotFoundException {
        String request = "SELECT * FROM \"Customer\" WHERE cust_id = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                return new Customer(id, result.getString("first_name"), result.getString("last_name"), result.getDate("birthday").toLocalDate(),/* result.getString("city")*/ new City("Foo")); //TODO replace by the real city latter :)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new CustomerNotFoundException(id);
    }
}
