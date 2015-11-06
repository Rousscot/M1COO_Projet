package gui;

import metier.Action;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 */
public abstract class Interaction {
    protected Map<String , String> commands;

    protected BufferedReader br;

    public Interaction(BufferedReader br){
        this.br = br;
        this.commands = new HashMap<>();
    }

    public abstract void interact() throws IOException;

    /**
     * I take the name of a command and I return a new instance of the corresponding class from the commands map.
     *
     * @param command the command corresponding of the class
     * @return An instance of an action class.
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public Action getInstanceOfClassNamed(String command) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Action) Class.forName(this.commands.get(command.toLowerCase())).newInstance();
    }

    /**
     * I generate an help to the user.
     */
    public void generateCommandHelp() {
        for (String command : this.commands.keySet()) {
            System.out.print(command + ": ");
            try {
                Action action = getInstanceOfClassNamed(command);
                System.out.println(action.description());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                //Do nothing. This is just help method for user.
            }
        }
        System.out.println();
    }

}
