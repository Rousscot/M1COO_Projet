import dao.ConnectionBdd;
import dao.exception.CannotInsertCustomerException;
import dao.exception.CustomerNotFoundException;
import dao.implement.CustomerDAO;
import domaine.Customer;
import domaine.destination.City;
import gui.MainInteractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

/**
 * Todo
 */
public class Main {
    public static void main(String[] args) throws IOException {

      /*  Customer cust = new Customer(null, "foo", "bar" , LocalDate.of(1993, 8, 20), new City("Galifrey"));
        try {
            new CustomerDAO(ConnectionBdd.current()).create(cust);
        } catch (CannotInsertCustomerException e) {
            e.printStackTrace();
        }*/
        try {
            Long id = Long.valueOf("1");
            System.out.println(new CustomerDAO(ConnectionBdd.current()).find(id));
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MainInteractions interaction = (new MainInteractions(br));
        while (true) {
            interaction.interact();
        }
    }
}
