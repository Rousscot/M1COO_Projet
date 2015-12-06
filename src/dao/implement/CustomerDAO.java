package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.Customer;
import domaine.destination.City;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 */
public class CustomerDAO extends DAO<Customer> {

    public CustomerDAO() {
        super();
    }

    @Override
    public Customer create(Customer customer) throws DAOException {
        String idRequest = "SELECT NEXTVAL('customer_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO customer (id_customer, first_name, last_name, birthday , city) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, customer.getFirstName());
                prepare.setString(3, customer.getLastName());
                prepare.setDate(4, Date.valueOf(customer.getBirthday()));
                prepare.setString(5, customer.getCity().toString()); //TODO switch to city latter.
                prepare.executeUpdate();
                customer = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(customer);
        }
        return customer;
    }

    @Override
    public void delete(Customer customer) throws DAOException {
        String request = "DELETE FROM customer WHERE id_customer = " + customer.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new DAOException(customer);
        }
    }

    @Override
    public Customer update(Customer customer) throws DAOException {
        String request = "UPDATE customer SET first_name = '" + customer.getFirstName() + "'," +
                " last_name = '" + customer.getLastName() + "'," +
                " birthday = '" + Date.valueOf(customer.getBirthday()) + "'," +
                " city = '" + customer.getCity().toString() + "'" + //TODO Use real city!
                " WHERE id_customer = " + customer.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            customer = this.find(customer.getId());
        } catch (SQLException e) {
            throw new DAOException(customer);
        }
        return customer;
    }

    @Override
    public Customer find(Long id) throws DAOException {
        String request = "SELECT * FROM customer WHERE id_customer = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                return new Customer(id, result.getString("first_name"), result.getString("last_name"), result.getDate("birthday").toLocalDate(),/* result.getString("city")*/ new City("Foo")); //TODO replace by the real city latter :)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }
}
