package gui;

import metier.Action;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * TODO
 */
public class MainInteractions extends Interaction {

    public MainInteractions(BufferedReader br) {
        super(br);
    }

    /**
     * I am the action of this class.
     * I display to the user the commands he can use then I launch the action he selected.
     *
     * @throws IOException todo
     */
    @Override
    public void interact() throws IOException {
        System.out.println("Bonjour, quelle action voulez vous effectuer ?");
        this.generateCommandHelp();
        String command = this.br.readLine().trim();
        try {
            Action action = getInstanceOfClassNamed(command);
            action.action(br);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            //We catch the exceptions for user convenience
            System.out.println("Mauvaise commande: " + command + ".");
            this.interact();
        }
    }
}
