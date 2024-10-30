package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabaseHandler {
    public static void saveUser(User user) {
        String query = "INSERT INTO user_profile (name, age, weight, height) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setDouble(3, user.getWeight());
            stmt.setDouble(4, user.getHeight());
            stmt.executeUpdate();
            System.out.println("User saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String name) {
        String query = "SELECT * FROM user_profile WHERE name = ?";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int age = rs.getInt("age");
                double weight = rs.getDouble("weight");
                double height = rs.getDouble("height");
                return new User(name, age, weight, height);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
