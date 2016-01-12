import factory.Agency;
import gui.AgencyGUI;

import java.io.IOException;

/**
 * Todo
 */
public class Main {
    public static void main(String[] args) throws IOException {
        new AgencyGUI(new Agency());
    }
}
