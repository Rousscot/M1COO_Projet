package dao.implement;

import dao.DAO;
import dao.exception.DAOException;
import domaine.Fly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * I am a DAO use to map a Fly with the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class FlyDAO extends DAO<Fly> {

    protected CityDAO dao;

    public FlyDAO() {
        super();
        this.dao = new CityDAO();
    }

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
                String insertRequest = "INSERT INTO fly ( id_fly, id_origin, id_destination, day, hour, duration, firstClassCapacity, firstClassPrice, secondClassCapacity, secondClassPrice, resignation ) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement prepare = this.connection.prepareStatement(insertRequest);
                prepare.setLong(1, id);
                prepare.setLong(2, fly.getOriginId());
                prepare.setLong(3, fly.getDestinationId());
                prepare.setInt(4, fly.getDay().getValue());
                prepare.setTime(5, new Time(Long.valueOf(fly.getHour().toSecondOfDay() * 1000)));
                prepare.setInt(6, fly.getDuration());
                prepare.setInt(7, fly.getFirstClassCapacity());
                prepare.setInt(8, fly.getFirstClassPrice());
                prepare.setInt(9, fly.getSecondClassCapacity());
                prepare.setInt(10, fly.getSecondClassCapacity());
                prepare.setInt(11, fly.getDaysOfResignation());
                prepare.executeUpdate();
                fly = this.find(id);
            }
        } catch (SQLException e) {
            throw new DAOException(fly);
        }
        return fly;
    }

    /**
     * I allow to delete a Fly from the database.
     *
     * @param fly the fly to delete.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public void delete(Fly fly) throws DAOException {
        try {
            String request = "DELETE FROM fly WHERE id_fly = " + fly.getId();
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
        } catch (SQLException e) {
            throw new DAOException(fly);
        }

    }

    /**
     * I allow to update a Fly in the database.
     *
     * @param fly the fly to update.
     * @return the fly.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Fly update(Fly fly) throws DAOException {
        LocalTime time = fly.getHour();
        String hour = time.getHour() + ":" + time.getMinute() + ":" + time.getSecond();
        String request = "UPDATE fly SET id_origin = '" + fly.getOriginId().toString() + "'," +
                " id_destination = '" + fly.getDestinationId().toString() + "'," +
                " day = '" + fly.getDay().getValue() + "'," +
                " hour = '" + hour + "'," +
                " duration = '" + fly.getDuration().toString() + "'," +
                " firstClassCapacity = '" + fly.getFirstClassCapacity().toString() + "'," +
                " firstClassPrice = '" + fly.getFirstClassPrice().toString() + "'," +
                " secondClassCapacity = '" + fly.getSecondClassCapacity().toString() + "'," +
                " secondClassPrice = '" + fly.getSecondClassPrice().toString() + "'," +
                " resignation = '" + fly.getDaysOfResignation().toString() + "'," +
                " WHERE id_fly = " + fly.getId().toString();
        try {
            this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(request);
            return this.find(fly.getId());
        } catch (SQLException e) {
            throw new DAOException(fly);
        }
    }

    /**
     * I allow to get a Fly in the database from his id.
     *
     * @param id the id of the Fly.
     * @return the Fly.
     * @throws DAOException is raise if there is a problem with the database.
     */
    @Override
    public Fly find(Long id) throws DAOException {
        String request = "SELECT * FROM fly WHERE id_fly = " + id;
        try {
            ResultSet result = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeQuery(request);
            if (result.first()) {
                return new Fly(id,
                        dao.find(result.getLong("id_origin")),
                        dao.find(result.getLong("id_destination")),
                        DayOfWeek.of(result.getInt("day")),
                        result.getTime("hour").toLocalTime(),
                        result.getInt("duration"),
                        result.getInt("firstClassCapacity"),
                        result.getInt("firstClassPrice"),
                        result.getInt("secondClassCapacity"),
                        result.getInt("secondClassPrice"),
                        result.getInt("resignation")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new DAOException(id);
    }

    public List<Fly> allFlies() throws DAOException {
        // For this one we don't have an ID in parameter because the agency is unique for now. 
        //TODO Maybe include a retry with  a time out in case of SQLException
        List<Fly> list = new ArrayList<>();
        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT id_fly FROM fly");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                list.add(find(result.getLong("id_fly")));
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return list;
    }
}
