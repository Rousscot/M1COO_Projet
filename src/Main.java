import dao.ConnectionBdd;
import dao.implement.CustomerDAO;
import domaine.Customer;
import domaine.destination.City;
import gui.MainInteractions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Todo
 */
public class Main {
    public static void main(String[] args) throws IOException {

        Customer cust = new Customer(null, "foo", "bar", LocalDate.of(1993, 8, 20), new City("Galifrey"));
        try {
            CustomerDAO custDAO = new CustomerDAO(ConnectionBdd.current());
            // Add
            cust = custDAO.create(cust);
            // Get
            System.out.println(custDAO.find(cust.id()));
            cust.firstName("Baracuda!");
            custDAO.update(cust);
            custDAO.delete(cust);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MainInteractions interaction = (new MainInteractions(br));
        while (true) {
            interaction.interact();
        }
    }
}
