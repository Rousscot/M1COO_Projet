package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.Customer;
import domaine.destination.City;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 */
public class CustomerDAO extends DAO<Customer> {

    protected CityDAO cityDao;

    public CustomerDAO() {
        super();
        cityDao = new CityDAO();
    }

    @Override
    public Customer create(Customer customer) throws DAOException {
        String idRequest = "SELECT NEXTVAL('customer_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO customer (id_customer, first_name, last_name, birthday , id_city) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, customer.getFirstName());
                prepare.setString(3, customer.getLastName());
                prepare.setDate(4, Date.valueOf(customer.getBirthday()));
                prepare.setLong(5, customer.getCityId());
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
                " id_city = '" + customer.getCityId().toString() + "'" +
                " WHERE id_customer = " + customer.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            return this.find(customer.getId());
        } catch (SQLException e) {
            throw new DAOException(customer);
        }
    }

    @Override
    public Customer find(Long id) throws DAOException {
        String request = "SELECT * FROM customer WHERE id_customer = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                return new Customer(id, result.getString("first_name"), result.getString("last_name"), result.getDate("birthday").toLocalDate(), cityDao.find(result.getLong("id_city")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }

    public List<Customer> allCustomers() throws DAOException{
        List<Customer> list = new ArrayList<>();
        try{
            PreparedStatement statement = this.connection.prepareStatement("SELECT id_customer FROM customer");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                list.add(find(result.getLong("id_customer")));
            }
        } catch (SQLException e){
            throw new DAOException();
        }
        return list;
    }
}












