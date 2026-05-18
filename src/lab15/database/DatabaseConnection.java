package lab15.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Configuration 
    private static final String URL      = "jdbc:mysql://localhost:3306/login_app";
    private static final String USER     = "root";        // change as needed
    private static final String PASSWORD = "";            // change as needed
    private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";

    // Singleton instance
    private static DatabaseConnection instance;
    private Connection connection;

    // Constructor (private – singleton) 
    private DatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Public API 

    public static DatabaseConnection getInstance()
            throws ClassNotFoundException, SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    /** Returns the live JDBC {@link Connection}. */
    public Connection getConnection() {
        return connection;
    }

    /** Closes the underlying connection and resets the singleton. */
    public static void closeConnection() {
        if (instance != null) {
            try {
                if (!instance.getConnection().isClosed()) {
                    instance.getConnection().close();
                    System.out.println("Database connection closed.");
                }
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            } finally {
                instance = null;
            }
        }
    }
}

