package domaine.exception;

import domaine.Fly;

/**
 * I am an exception raised when a Fly is not found.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class FlyNotFoundException extends Exception {

    /**
     * The Fly not found.
     */
    protected final Fly fly;

    /**
     * I am the constructor of the exception.
     *
     * @param fly the Fly needed to find.
     */
    public FlyNotFoundException(Fly fly) {
        this.fly = fly;
    }

    /**
     * I am a getter that allow to get the id.
     *
     * @return the Fly of the object that the DAO wanted to find.
     */
    public Fly getFly() {
        return fly;
    }

}
