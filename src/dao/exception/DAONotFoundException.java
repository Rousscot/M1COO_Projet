package dao.exception;

import java.sql.SQLException;

/**
 * TODO
 */
public class DAONotFoundException extends SQLException {

    protected final Long id;

    /**
     * todo
     * @param id
     */
    public DAONotFoundException(Long id) {
        this.id = id;
    }

    public Long id(){
        return id;
    }
}
