package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRecordApp {
    private final List<Student> students = new ArrayList<>();

    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            printMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number (1-3).\n");
                continue;
            }
            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> displayAllStudents();
                case 3 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice. Try again.\n");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("===== Student Record Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Exit");
    }

    private void addStudent(Scanner scanner) {
        Student student = new Student();
        student.inputDetails(scanner);
        students.add(student);
        System.out.println("Student added successfully.\n");
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.\n");
            return;
        }
        for (Student s : students) {
            s.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new StudentRecordApp().run();
    }
}
