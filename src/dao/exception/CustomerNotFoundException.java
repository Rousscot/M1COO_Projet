package dao.exception;

/**
 * TODO
 */
public class CustomerNotFoundException extends DAONotFoundException {

    public CustomerNotFoundException(Integer id) {
        super(id);
    }

}
