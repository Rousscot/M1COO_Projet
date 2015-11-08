package gui;

import gui.action.Quit;
import gui.exception.NoActionForCommand;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class MainInteractions extends Interaction {

    public MainInteractions(BufferedReader br) {
        super(br);
        this.commands.put(Quit.COMMAND, "gui.action.Quit");
    }
    
    //TODO: Maybe a part should go on the superclass.
    /**
     * I am the action of this class.
     * I display to the user the commands he can use then I launch the action he selected.
     *
     * @throws IOException todo
     */
    @Override
    public void interact() throws IOException {
        System.out.println("Hello! What action do you want to execute?");
        this.generateCommandHelp();
        String command = this.br.readLine().trim();
        try {
            Action action = getInstanceOfClassNamed(command);
            action.action(br);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            //We catch the exceptions for user convenience
            System.out.println("Something is wrong with this namespace: " + this.commands.get(command) + ".");
            this.interact();
        } catch (NoActionForCommand e) {
            System.out.println("Command doesn't exist: " + e.command());
            this.interact();
        }
    }
}
