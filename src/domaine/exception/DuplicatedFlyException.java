package domaine.exception;

import domaine.Fly;

/**
 * Created by JeCisC on 06/12/2015.
 */
public class DuplicatedFlyException extends Exception {

    protected Fly fly;

    public DuplicatedFlyException(Fly fly) {
        this.fly = fly;
    }

    public Fly getFly() {
        return this.fly;
    }

}
