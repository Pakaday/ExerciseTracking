package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExerciseDatabaseHandler {
    public static void saveExercise(Exercise exercise) {
        String query = "INSERT INTO exercise_list (name, duration, calories) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, exercise.getName());
            stmt.setInt(2, exercise.getDuration());
            stmt.setDouble(3, exercise.getCaloriesBurned());
            stmt.executeUpdate();
            System.out.println("Exercise saved to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
