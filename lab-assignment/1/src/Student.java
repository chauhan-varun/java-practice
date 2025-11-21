package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private char grade;

    public Student() {
        super();
    }

    public Student(int rollNo, String name, String course, double marks) {
        super(name);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    public void inputDetails(Scanner scanner) {
        System.out.print("Enter Roll No: ");
        rollNo = readInt(scanner);

        System.out.print("Enter Name: ");
        name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Re-enter Name: ");
            name = scanner.nextLine().trim();
        }

        System.out.print("Enter Course: ");
        course = scanner.nextLine().trim();
        while (course.isEmpty()) {
            System.out.print("Course cannot be empty. Re-enter Course: ");
            course = scanner.nextLine().trim();
        }

        System.out.print("Enter Marks (0-100): ");
        marks = readDoubleInRange(scanner, 0, 100);
        calculateGrade();
    }

    private int readInt(Scanner scanner) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid integer. Try again: ");
            }
        }
    }

    private double readDoubleInRange(Scanner scanner, double min, double max) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < min || value > max) {
                    System.out.print("Value must be between " + min + " and " + max + ". Try again: ");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Try again: ");
            }
        }
    }

    public void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 80) grade = 'B';
        else if (marks >= 70) grade = 'C';
        else grade = 'D';
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public char getGrade() {
        return grade;
    }
}
