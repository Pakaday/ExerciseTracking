package model;

public class Exercise {
    private String name;
    private int duration; // Duration in minutes
    private double caloriesBurned;

    public Exercise(String name, int duration, double caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void displayExerciseInfo() {
        System.out.println("Exercise Name: " + name);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Calories burned: " + caloriesBurned + " kcal");
    }
}
