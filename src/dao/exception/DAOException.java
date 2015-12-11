package dao.exception;

import domaine.DAOSerializable;

import java.sql.SQLException;

/**
 * TODO
 */
public class DAOException extends SQLException {
    protected Long id;

    //TODO : See if we keep this one.
    public DAOException(){
    }

    public DAOException(Long id){
        this.id = id;
    }

    public DAOException(DAOSerializable object){
        this.id = object.getId();
    }

    public Long getId(){
        return id;
    }
}
