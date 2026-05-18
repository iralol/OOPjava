package lab15.dao;

import lab15.database.DatabaseConnection;
import lab15.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static final String AUTH_QUERY =
        "SELECT * FROM users WHERE username = ? AND password = ?";
    /**
     * Validates a username/password pair against the database.
     *
     * @param username the entered username
     * @param password the entered password
     * @return the matching {@link User} if credentials are valid, or {@code null}
     * @throws ClassNotFoundException if the JDBC driver is missing
     * @throws SQLException           on any database error
     */
    public User authenticate(String username, String password)
            throws ClassNotFoundException, SQLException {

        Connection        con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement pst = con.prepareStatement(AUTH_QUERY);

        pst.setString(1, username);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return new User(
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("password")
            );
        }

        return null; // credentials did not match
    }
}
