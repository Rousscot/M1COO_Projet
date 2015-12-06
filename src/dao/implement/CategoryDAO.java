package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.destination.Category;
import domaine.exception.RoomNotFoundException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class CategoryDAO extends DAO<Category> {

    @Override
    public Category create(Category category) throws DAOException {

        // All rooms should be created when we add them to the category. So no need to add them.

        String idRequest = "SELECT NEXTVAL('category_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO category (id_category, capacity, price, name , id_hotel) VALUES(?, ?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setInt(2, category.getCapacity());
                prepare.setInt(3, category.getPrice());
                prepare.setString(4, category.getDesignation());
                prepare.setLong(5, category.getHotelId());
                prepare.executeUpdate();
                category = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(category);
        }
        return category;
    }

    @Override
    public void delete(Category category) throws DAOException {
        try {
            category.deleteAllRooms();

            String request = "DELETE FROM category WHERE id_category = " + category.getId();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException | RoomNotFoundException e) {
            throw new DAOException(category);
        }
    }

    @Override
    public Category update(Category category) throws DAOException {
        // I do not check if the rooms need update because this should be handle by the Room object.
        String request = "UPDATE category SET name = '" + category.getDesignation() + "'," +
                " category. = '" + category.getCapacity() + "'," +
                " price = '" +category.getPrice() + "'," +
                " id_hotel = '" + category.getHotelId() + "'" +
                " WHERE id_category = " + category.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            return this.find(category.getId());
        } catch (SQLException e) {
            throw new DAOException(category);
        }
    }

    @Override
    public Category find(Long id) throws DAOException {
        String request = "SELECT * FROM category WHERE id_category = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                // We do not get the rooms, I am lazy.
                return new Category(id, result.getString("name"), result.getInt("capacity"), result.getInt("price"), null ); //TODO replace by the real Hotel latter :)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }
}
