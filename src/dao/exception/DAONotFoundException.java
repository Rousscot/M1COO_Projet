package dao.exception;

import java.sql.SQLException;

/**
 * TODO
 */
public class DAONotFoundException extends SQLException {

    protected final Integer id;

    /**
     * todo
     * @param id
     */
    public DAONotFoundException(Integer id) {
        this.id = id;
    }

    public Integer id(){
        return id;
    }
}
