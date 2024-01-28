import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Initialization code, if needed
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // CRUD Operations

    public void createUser(String username, String email) {
        try (Connection connection = connect()) {
            String sql = "INSERT INTO users (username, email) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, email);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(int userId, String newUsername, String newEmail) {
        try (Connection connection = connect()) {
            String sql = "UPDATE users SET username = ?, email = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, newEmail);
                preparedStatement.setInt(3, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try (Connection connection = connect()) {
            String sql = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayUsers() {
        try (Connection connection = connect()) {
            String sql = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("User ID: " + resultSet.getInt("id"));
                        System.out.println("Username: " + resultSet.getString("username"));
                        System.out.println("Email: " + resultSet.getString("email"));
                        System.out.println("--------------");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods and attributes relevant to the class
}


public class Main {
    public static void main(String[] args) {
        // Get the instance of the DatabaseConnection class
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();

        // Create user
        dbConnection.createUser("john_doe", "john@example.com");

        // Update user
        dbConnection.updateUser(1, "john_doe_updated", "updated@example.com");

        // Display all users
        dbConnection.displayUsers();

        // Delete user
        dbConnection.deleteUser(1);

        // Display users after deletion
        dbConnection.displayUsers();
    }
}
