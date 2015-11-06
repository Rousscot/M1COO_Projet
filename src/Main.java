import gui.MainInteractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by JeCisC on 06/11/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MainInteractions interaction = (new MainInteractions(br));
        while (true) {
            interaction.interact();
        }
    }
}
