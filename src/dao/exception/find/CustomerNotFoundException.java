package dao.exception.find;

import dao.exception.DAONotFoundException;

/**
 * I am an exception raised in case the DAO cannot find a Customer into the database.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class CustomerNotFoundException extends DAONotFoundException {

    public CustomerNotFoundException(Long id) {
        super(id);
    }

}
