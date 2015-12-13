package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.destination.Hotel;
import domaine.exception.CategoryNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ferlicotdelbe on 11/12/15.
 */
public class HotelDAO extends DAO<Hotel> {

    protected CityDAO dao;

    public HotelDAO() {
        super();
        dao = new CityDAO();
    }

    @Override
    public Hotel create(Hotel hotel) throws DAOException {
        // All categories should be created when we add them to the hotel. So no need to add them.

        String idRequest = "SELECT NEXTVAL('hotel_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO hotel (id_hotel, name, resignationDays , id_city) VALUES(?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setString(2, hotel.getName());
                prepare.setInt(3, hotel.getResignationDays());
                prepare.setLong(4, hotel.getCityId());
                prepare.executeUpdate();
                hotel = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(hotel);
        }
        return hotel;
    }

    @Override
    public void delete(Hotel hotel) throws DAOException {
        try {
            hotel.deleteAllCategories();
            String request = "DELETE FROM hotel WHERE id_hotel = " + hotel.getId();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException | CategoryNotFoundException e) {
            throw new DAOException(hotel);
        }
    }

    @Override
    public Hotel update(Hotel hotel) throws DAOException {

        // I do not check if the categories need update because this should be handle by the Category object.
        String request = "UPDATE hotel SET name = '" + hotel.getName() + "'," +
                " resignationDays = '" + hotel.getResignationDays() + "'," +
                " id_city = '" + hotel.getCityId() + "'" +
                " WHERE id_hotel = " + hotel.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            return this.find(hotel.getId());
        } catch (SQLException e) {
            throw new DAOException(hotel);
        }
    }

    @Override
    public Hotel find(Long id) throws DAOException {
        String request = "SELECT * FROM hotel WHERE id_hotel = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                // We do not get the categories, I am lazy.
                return new Hotel(id, result.getString("name"), result.getInt("resignationDays"), dao.find(result.getLong("id_city")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }

    public List<Hotel> allHotelsForId(Long id) throws DAOException {
        return listOfAllObject("id_hotel", "hotel", "id_city", id);
    }
}
