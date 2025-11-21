package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        try {
            System.out.print("Enter Roll No (Integer): ");
            String rollInput = scanner.nextLine();
            if (rollInput.isBlank()) throw new IllegalArgumentException("Roll no cannot be empty");
            Integer roll = Integer.valueOf(rollInput.trim());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) throw new IllegalArgumentException("Name cannot be empty");

            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();
            if (email.isEmpty() || !email.contains("@")) throw new IllegalArgumentException("Invalid email");

            System.out.print("Enter Course: ");
            String course = scanner.nextLine().trim();
            if (course.isEmpty()) throw new IllegalArgumentException("Course cannot be empty");

            System.out.print("Enter Marks: ");
            String marksInput = scanner.nextLine();
            if (marksInput.isBlank()) throw new IllegalArgumentException("Marks cannot be empty");
            Double marks = Double.valueOf(marksInput.trim());
            if (marks < 0.0 || marks > 100.0) throw new IllegalArgumentException("Marks must be between 0 and 100");

            Student student = new Student(roll, name, email, course, marks);
            manager.addStudent(student);

            manager.displayStudent(roll);

            manager.saveStudent(roll);

            System.out.println("Program execution completed.");

        } catch (NumberFormatException nfe) {
            System.err.println("Invalid number format: " + nfe.getMessage());
        } catch (StudentNotFoundException snfe) {
            System.err.println("Error: " + snfe.getMessage());
        } catch (IllegalArgumentException iae) {
            System.err.println("Validation error: " + iae.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
