package dao.exception;

import domaine.DAOSerializable;

import java.util.LongSummaryStatistics;

/**
 * TODO
 */
public class DAOException extends Exception {
    protected Long id;

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
