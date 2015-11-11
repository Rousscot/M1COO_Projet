package dao.exception.find;

import dao.exception.DAONotFoundException;

/**
 * TODO
 */
public class CustomerNotFoundException extends DAONotFoundException {

    public CustomerNotFoundException(Long id) {
        super(id);
    }

}
