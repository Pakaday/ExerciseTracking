package model;

import java.util.ArrayList;

public class ActivityLog {
    private ArrayList<Exercise> exercises;

    public ActivityLog() {
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
        System.out.println("Exercise added to log.");
    }

    public void displayExercise() {
        if (exercises.isEmpty()) {
            System.out.println("No exercises logged.");
        } else {
            System.out.println("Exercise Log:");
            for (Exercise exercise : exercises) {
                exercise.displayExerciseInfo();
                System.out.println();
            }
        }
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
