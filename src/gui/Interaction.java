package gui;

import gui.exception.NoActionForCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * I am an abstract class that describe an interaction class.
 *
 * I know a list of commands.
 * I can launch an action for each command.
 * I can communicate  with the user with a BufferedReader.
 *
 * I work with the subclasses of Action.
 *
 * @author Cyril Ferlicot and Aurelien Rousseau
 */
public abstract class Interaction {

    /**
     * I am a Map with commands as key and namespace as value.
     */
    protected Map<String, String> commands;

    /**
     * I am a BufferedReader use to communicate with the user.
     */
    protected BufferedReader br;

    public Interaction(BufferedReader br) {
        this.br = br;
        this.commands = new HashMap<>();
    }

    /**
     * I ask to the user a command and I launch an action with his command.
     * If there is a problem with the command I just ask again.
     *
     * @throws IOException if there is a problem with the BufferedReader.
     */
    public abstract void interact() throws IOException;

    /**
     * I take the name of a command and I return a new instance of the corresponding class from the commands map.
     *
     * @param command the command corresponding of the class
     * @return An instance of an action class.
     * @throws InstantiationException if I cannot instantiate the Action corresponding to the command.
     * @throws IllegalAccessException if I cannot access to the Action.
     * @throws ClassNotFoundException if I cannot find the class of the command.
     * @throws NoActionForCommand if the command doesn't exist on the map.
     */
    public Action getInstanceOfClassNamed(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoActionForCommand {
        String namespace = this.commands.get(command.toLowerCase());
        if(namespace == null){
            throw new NoActionForCommand(command);
        }
        return (Action) Class.forName(namespace).newInstance();
    }

    /**
     * I generate an help to the user.
     */
    public void generateCommandHelp() {

        for (String command : this.commands.keySet()) {

            try {
                Action action = getInstanceOfClassNamed(command);
                System.out.println(String.format("%-10s:    %25s", command , action.description()));
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoActionForCommand e) {
                //Do nothing. This is just help method for user.
            }
        }
        System.out.println();
    }

}
