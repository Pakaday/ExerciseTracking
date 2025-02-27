package model;

import java.util.ArrayList;
import java.util.List;

public class ActivityLog {
    private List<Exercise> exercises = new ArrayList<>();

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public void clearLog() {
        exercises.clear();
    }

    public void displayExercise() {
        if (exercises.isEmpty()) {
            System.out.println("No exercises found");
        } else {
            System.out.println("\nExercise Log:");
            for (Exercise exercise : exercises) {
                exercise.displayExerciseInfo();
                System.out.println();
            }
        }
    }
}