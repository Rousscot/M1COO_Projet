package domaine;

/**
 * I am an Interface needed to improve the DAO.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public interface DAOSerializable {

    /**
     * I allow to return an Id for the object.
     *
     * @return the id of the object into the DAO.
     */
    Long getId();

}
