package dao.exception;

import java.sql.SQLException;

/**
 * I am an exception raised when the DAO can't find an object in the database from his id.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class DAONotFoundException extends SQLException {

    /**
     * The id of the object.
     */
    protected final Long id;

    /**
     * I am the constructor of the exception.
     *
     * @param id the id of the object the DAO needed to find.
     */
    public DAONotFoundException(Long id) {
        this.id = id;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the id of the object that the DAO wanted to find.
     */
    public Long id() {
        return id;
    }
}
