import model.*;

import java.util.Scanner;

public class Main {
    private static User user = null;
    private static ActivityLog activityLog = new ActivityLog();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Load existing user
        System.out.println("Enter name to load profile:");
        String name = scanner.nextLine();
        user = UserDatabaseHandler.getUser(name);

        if (user != null) {
            System.out.println("Profile loaded successfully");
        } else {
            System.out.println("No profile found.");
        }

        while (running) {
            System.out.println("\nExercise Tracker");
            System.out.println("1. Create user profile");
            System.out.println("2. View user profile");
            System.out.println("3. Log new exercise");
            System.out.println("4. View exercise log");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createUserProfile(scanner);
                    break;
                case 2:
                    viewUserProfile();
                    break;
                case 3:
                    if (user == null) {
                        System.out.println("Please create a user profile");
                    } else {
                        logNewExercise(scanner);
                    }
                    break;
                case 4:
                    viewExerciseLog();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createUserProfile(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Enter your weight in pounds: ");
        double weight = scanner.nextDouble();

        System.out.println("Enter your height in inches: ");
        double height = scanner.nextDouble();

        // Store in user
        user = new User(name, age, weight, height);
        // Save user to database before message
        UserDatabaseHandler.saveUser(user);
        System.out.println("Profile created successfully.");

    }

    private static void viewUserProfile() {
        if (user == null) {
            System.out.println("No profile found. Please create a new profile.");
        } else {
            User dbUser = UserDatabaseHandler.getUser(user.getName());
            if (dbUser != null) {
                dbUser.displayUserInfo();
            } else {
                System.out.println("User not found.");
            }
//            user.displayUserInfo();
        }
    }

    private static void logNewExercise(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter exercise name: ");
        String name = scanner.nextLine();

        System.out.println("Enter exercise duration in minutes: ");
        int duration = scanner.nextInt();

        System.out.println("Calories burned: ");
        double caloriesBurned = scanner.nextDouble();

        // Create new exercise object
        Exercise exercise = new Exercise(name, duration, caloriesBurned);
//        activityLog.addExercise(exercise);
        ExerciseDatabaseHandler.saveExercise(exercise);
        System.out.println("Exercise logged successfully!");

    }

    private static void viewExerciseLog() {
        activityLog.clearLog(); // Clear current log to avoid duplicates
        // Retrieve exercises from database and add to activitylog
        for (Exercise exercise : ExerciseDatabaseHandler.getAllExercises()) {
            activityLog.addExercise(exercise);
        }
        activityLog.displayExercise();
        }
    }