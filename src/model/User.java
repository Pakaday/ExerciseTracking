package model;

public class User {
    private String name;
    private int age;
    private double weight;
    private  double height;

    public User(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void displayUserInfo() {
        System.out.println("User Profile:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Weight: " + weight + " lb");
        System.out.println("Height: " + height  + " inches");
    }
}
