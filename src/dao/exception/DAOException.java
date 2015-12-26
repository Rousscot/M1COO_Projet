package dao.exception;

import domaine.DAOSerializable;

import java.sql.SQLException;

/**
 * I am an exception raise by a DAO if something went wrong with the database.
 * <p>
 * I can remember an Id but not the object of the problem since we cannot use generic type in Java for exceptions.
 * <p>
 * I should only be raise by a DAO.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class DAOException extends SQLException {

    /**
     * The id of the problematic object. This one can be null sometimes.
     */
    protected Long id;

    //TODO : See if we keep this one.
    public DAOException() {
    }

    public DAOException(Long id) {
        this.id = id;
    }

    public DAOException(DAOSerializable object) {
        this.id = object.getId();
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        if (id == null) {
            return "";
        } else {
            return "Erreur sur id : " + getId().toString();
        }
    }
}
