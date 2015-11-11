package domaine;

import domaine.destination.City;

/**
 * I am a class that describe a fly.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public class Fly {

    protected final City origin;

    protected final City destination;

    public Fly(City origin, City destination){
        this.origin = origin;
        this.destination = destination;
    }
}
