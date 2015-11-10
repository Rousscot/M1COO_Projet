package dao.exception;

/**
 * TODO
 */
public class CustomerNotFoundException extends DAONotFoundException {

    public CustomerNotFoundException(Long id) {
        super(id);
    }

}
