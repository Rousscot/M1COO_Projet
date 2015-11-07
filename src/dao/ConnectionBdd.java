package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * todo
 */
public class ConnectionBdd {

    protected String url = "jdbc:postgresql://postgresql1.alwaysdata.com:5432/cestpasfaux_agency";

    protected String user = "cestpasfaux";

    protected String passwd = "cotelette";

    protected static Connection connection;

    private ConnectionBdd() {
        try {
            //I just try to instantiate the driver to check that the driver is here.
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");
            connection = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection O.K.");
        } catch (ClassNotFoundException e) {
            System.out.println("There is a problem with the instantiation of the driver. Check that the driver is on your classpath.");
            System.exit(10);
        } catch (SQLException e) {
            System.out.println("There is a problem with the url/login/password of the database :(");
            System.exit(15);
        }
    }

    /**
     * TODO
     * @return
     */
    public static Connection current() {
        if (connection == null) {
            new ConnectionBdd();
        }
        return connection;
    }
}
