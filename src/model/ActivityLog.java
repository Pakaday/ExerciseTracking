package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityLog {
    private ArrayList<Exercise> exerciseList = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO exercise_list (name, duration, calories) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, exercise.getName());
            pstmt.setInt(2, exercise.getDuration());
            pstmt.setDouble(3, exercise.getCaloriesBurned());
            pstmt.executeUpdate();
            exerciseList.add(exercise); // Also keep in memory
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadExercises() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT name, duration, calories_burned FROM exercises";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            exerciseList.clear(); // Clear the existing list
            while (rs.next()) {
                String name = rs.getString("name");
                int duration = rs.getInt("duration");
                double caloriesBurned = rs.getDouble("calories_burned");
                exerciseList.add(new Exercise(name, duration, caloriesBurned));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayExercise() {
        if (exerciseList.isEmpty()) {
            System.out.println("No exercises logged yet.");
            return;
        }
        System.out.println("\nExercise Log:");
        for (Exercise exercise : exerciseList) {
            exercise.displayExerciseInfo();
            System.out.println();
        }
    }
}
