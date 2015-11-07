package dao.exception;

/**
 * TODO
 */
public class DAONotFoundException extends Exception {

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
