package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.destination.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * I am a DAO use to map a Room with the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class RoomDAO extends DAO<Room> {

    /**
     * I might need to manage categories so I remember a CategoryDAO.
     */
    protected CategoryDAO dao;

    public RoomDAO() {
        super();
        dao = new CategoryDAO();
    }

    /**
     * I allow to create a new Room inside the database.
     *
     * @param room the category I need to add.
     * @return the category with the right id.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Room create(Room room) throws DAOException {
        String idRequest = "SELECT NEXTVAL('room_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO room (id_room, room_number, isbusy, id_category) VALUES(?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setInt(2, room.getNumber());
                prepare.setBoolean(3, room.isBusy());
                prepare.setLong(4, room.getCategoryId());
                prepare.executeUpdate();
                room = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(room);
        }
        return room;
    }

    /**
     * I allow to delete a Room from the database.
     *
     * @param room the category to delete.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public void delete(Room room) throws DAOException {
        String request = "DELETE FROM room WHERE id_room = " + room.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new DAOException(room);
        }
    }

    /**
     * I allow to update a Room in the database.
     *
     * @param room the category to update.
     * @return the category.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Room update(Room room) throws DAOException {
        String request = "UPDATE room SET isbusy = '" + room.isBusy() + "'," +
                " room_number = ''" + room.getNumber() + "'" +
                " id_category = '" + room.getCategoryId() + "'" +
                " WHERE id_room = " + room.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            return this.find(room.getId());
        } catch (SQLException e) {
            throw new DAOException(room);
        }
    }

    /**
     * I allow to get a Room in the database from his id.
     *
     * @param id the id of the room.
     * @return the room.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Room find(Long id) throws DAOException {
        String request = "SELECT * FROM room WHERE id_room = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                //TODO Check that we do not have a loop.
                Room room = new Room(id, dao.find(result.getLong("id_category")), result.getInt("room_number"));
                room.setBusy(result.getBoolean("isBusy"));
                return room;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }

    /**
     * I allow to get a list of Rooms of a Category where the id of the Category is `id`.
     *
     * @param id the id of the Category.
     * @return the list of rooms of the category.
     * @throws DAOException is raise if there is a problem with database.
     */
    public List<Room> allRoomsForId(Long id) throws DAOException {
        return listOfAllObject("id_room", "room", "id_category", id);
    }
}
