package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Exercise> getAllExercises() {
        List<Exercise> exercises = new ArrayList<>();
        String query = "SELECT name, duration, calories FROM exercise_list";
        try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Exercise exercise = new Exercise(
                        rs.getString("name"),
                        rs.getInt("duration"),
                        rs.getDouble("calories")
                );
                exercises.add(exercise);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercises;
    }
}
