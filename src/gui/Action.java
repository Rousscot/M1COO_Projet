package gui;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * I am an abstract class that define an action.
 * An action should have a COMMAND static final attribute that is a String but I cannot force it since Java use static and doesn't have metaclass.
 *
 * @author Cyril Ferlicot and Aurélien Rousseau
 */
public abstract class Action {

    /**
     * I am an action that can execute the class.
     *
     * @param br a BufferedReader if the action need to interact with the user.
     * @throws IOException todo
     */
    public abstract void action(BufferedReader br) throws IOException;

    /**
     * I return a description for an action.
     * @return a description of the action.
     */
    public abstract String description();
}