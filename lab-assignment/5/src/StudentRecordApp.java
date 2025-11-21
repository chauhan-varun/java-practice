import model.Student;
import service.StudentManager;
import util.StudentNotFoundException;

import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentRecordApp {
    private static StudentManager manager;
    private static Scanner scanner;

    public static void main(String[] args) {
        manager = new StudentManager();
        scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  Student Record Management System         ║");
        System.out.println("║  Dr. Manish Kumar                         ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        boolean running = true;

        while (running) {
            try {
                displayMenu();
                int choice = getUserChoice();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewAllStudents();
                        break;
                    case 3:
                        searchByName();
                        break;
                    case 4:
                        deleteByName();
                        break;
                    case 5:
                        sortByMarks();
                        break;
                    case 6:
                        saveAndExit();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Capstone Student Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search by Name");
        System.out.println("4. Delete by Name");
        System.out.println("5. Sort by Marks");
        System.out.println("6. Save and Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter choice: ");
        return scanner.nextInt();
    }

    private static void addStudent() {
        try {
            Student student = new Student();
            student.inputDetails(scanner);
            manager.addStudent(student);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input format! Please try again.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("An error occurred while adding student: " + e.getMessage());
        }
    }

    private static void viewAllStudents() {
        try {
            manager.viewAllStudents();
        } catch (Exception e) {
            System.out.println("An error occurred while viewing students: " + e.getMessage());
        }
    }

    private static void searchByName() {
        try {
            scanner.nextLine();
            System.out.print("Enter name to search: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty!");
                return;
            }

            Student student = manager.searchStudent(name);
            System.out.println("\nStudent Info:");
            student.displayDetails();

        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while searching: " + e.getMessage());
        }
    }

    private static void deleteByName() {
        try {
            scanner.nextLine();
            System.out.print("Enter name to delete: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty!");
                return;
            }

            manager.deleteStudent(name);

        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while deleting: " + e.getMessage());
        }
    }

    private static void sortByMarks() {
        try {
            manager.sortByMarks();
        } catch (Exception e) {
            System.out.println("An error occurred while sorting: " + e.getMessage());
        }
    }

    private static void saveAndExit() {
        try {
            manager.saveToFile();
            System.out.println("Saved and exiting.");
            System.out.println("\nThank you for using Student Record Management System!");
        } catch (Exception e) {
            System.out.println("An error occurred while saving: " + e.getMessage());
        }
    }
}
