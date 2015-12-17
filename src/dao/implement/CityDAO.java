package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.destination.City;
import domaine.exception.HotelNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class CityDAO extends DAO<City> {

    @Override
    public City create(City city) throws DAOException {

        // All hotels should be created when we add them to the City. So no need to add them.

        String idRequest = "SELECT NEXTVAL('city_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO city (id_city, name) VALUES(?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, city.getName());
                prepare.executeUpdate();
                city = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(city);
        }
        return city;
    }

    @Override
    public void delete(City city) throws DAOException {
        try {
            city.deleteAllHotels();
            String request = "DELETE FROM city WHERE id_city = " + city.getId();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException | HotelNotFoundException e) {
            throw new DAOException(city);
        }

    }

    @Override
    public City update(City city) throws DAOException {

        // I do not check if the hotels need update because this should be handle by the Hotel object.
        String request = "UPDATE city SET name = '" + city.getName() + "'," +
                " WHERE id_city = " + city.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            return this.find(city.getId());
        } catch (SQLException e) {
            throw new DAOException(city);
        }
    }

    @Override
    public City find(Long id) throws DAOException {
        String request = "SELECT * FROM city WHERE id_city = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                // We do not get the hotels, I am lazy.
                return new City(id, result.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }

    // For this one we don't have an ID in parameter because the agency is unique for now. 
    public List<City> allCities() throws DAOException {
        //TODO Maybe include a retry with  a time out in case of SQLException
        List<City> list = new ArrayList<>();
        String request = "SELECT id_city FROM city";
        try {
            PreparedStatement statement = this.connection.prepareStatement(request);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                list.add(find(result.getLong("id_city")));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return list;
    }
}
