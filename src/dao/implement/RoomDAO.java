package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.destination.Category;
import domaine.destination.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class RoomDAO extends DAO<Room> {

    @Override
    public Room create(Room room) throws DAOException {
        String idRequest = "SELECT NEXTVAL('room_id_seq') AS id";
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(idRequest);
            if (result.first()) {
                long id = result.getLong("id");
                String insertRequest = "INSERT INTO room (id_room, isbusy, id_category) VALUES(?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setBoolean(2, room.isBusy());
                prepare.setLong(3, room.getCategoryId());
                prepare.executeUpdate();
                room = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(room);
        }
        return room;
    }

    @Override
    public void delete(Room room) throws DAOException {
        String request = "DELETE FROM room WHERE id_room = " + room.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new DAOException(room);
        }
    }

    @Override
    public Room update(Room room) throws DAOException {
        String request = "UPDATE room SET isbusy = '" + room.isBusy() + "'," +
                " id_category = '" + room.getCategoryId()+ "'" +
                " WHERE id_room = " + room.getId();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            room = this.find(room.getId());
        } catch (SQLException e) {
            throw new DAOException(room);
        }
        return room;
    }

    @Override
    public Room find(Long id) throws DAOException {
        String request = "SELECT * FROM room WHERE id_room = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                Room room = new Room(id, new Category(null, null, null, null) /*TODO Finish this :°*/);
                room.setBusy(result.getBoolean("isBusy"));
                return room;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }
}
