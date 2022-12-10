package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

import static java.util.jar.Pack200.Packer.PASS;
import static javafx.css.StyleOrigin.USER;
import static javafx.scene.input.DataFormat.URL;



/**
 * Get a connection to database
 * @return Connection object
 */


public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/jdbc";
    public static final String USER = "carolina";
    public static final String PASS = "carolina";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public static void main(String[] args) {

        Connection connection = ConnectionFactory.getConnection();
    }
//findById() {}
//findAll() {}
//update() {}
//create() {}
//delete() {}
}
