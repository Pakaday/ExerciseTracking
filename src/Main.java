import model.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your age: ");
        int age = scanner.nextInt();

        System.out.println("Enter your weight in pounds: ");
        double weight = scanner.nextDouble();

        System.out.println("Enter your height in inches: ");
        double height = scanner.nextDouble();

        // Create a new User
        User user = new User(name, age, weight, height);

        // Display user profile info
        user.displayUserInfo();

        scanner.close();
    }
}