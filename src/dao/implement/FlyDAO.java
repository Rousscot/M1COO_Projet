package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.Fly;
import domaine.destination.City;
import domaine.exception.HotelNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * I am a DAO use to map a Fly with the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class FlyDAO extends DAO<Fly> {

    /**
     * I allow to create a new Fly inside the database.
     *
     * @param fly the fly I need to add.
     * @return the fly with the right id.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Fly create(Fly fly) throws DAOException {
        String idRequest = "SELECT NEXTVAL('fly_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO city ( id_fly, id_origin, id_destination, day, hour, duration, firstClassCapacity, secondClassCapacity, resignation ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setLong(2, fly.getOriginId());
                prepare.setLong(3, fly.getDestinationId());
                prepare.executeUpdate();
                fly = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(fly);
        }
        return fly;
    }

    /**
     * I allow to delete a City from the database.
     *
     * @param city the category to delete.
     * @throws DAOException is raise if there is a problem with the database.
     */
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

    /**
     * I allow to update a City in the database.
     *
     * @param city the category to update.
     * @return the category.
     * @throws DAOException is raise if there is a problem with the database.
     */
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

    /**
     * I allow to get a City in the database from his id.
     *
     * @param id the id of the city.
     * @return the category.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Fly find(Long id) throws DAOException {
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


    /**
     * I allow to get a list of cities of the Agency.
     *
     * @return the list of cities of the agency.
     * @throws DAOException is raise if there is a problem with database.
     */
    public List<City> allCities() throws DAOException {
        // For this one we don't have an ID in parameter because the agency is unique for now. 
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
