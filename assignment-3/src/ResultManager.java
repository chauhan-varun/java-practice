import java.util.InputMismatchException;
import java.util.Scanner;
public class ResultManager {
    private static final int MAX_STUDENTS = 100;
    private final Student[] students = new Student[MAX_STUDENTS];
    private int size = 0;

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ResultManager manager = new ResultManager();
        manager.mainMenu();
    }

    public void mainMenu() {
        boolean running = true;
        System.out.println("===== Student Result Management System =====");
        while (running) {
            try {
                System.out.println("1. Add Student");
                System.out.println("2. Show Student Details");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> showStudentDetails();
                    case 3 -> {
                        running = false;
                        System.out.println("Exiting program. Thank you!");
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Error: Input type mismatch. Please enter numeric choices and marks correctly.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            } finally {
                if (running) {
                    System.out.println("Returning to main menu...\n");
                }
            }
        }
        scanner.close();
    }

    private void addStudent() {
        try {
            if (size >= MAX_STUDENTS) {
                System.out.println("Capacity reached. Cannot add more students.");
                return;
            }
            System.out.print("Enter Roll Number: ");
            int roll = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = scanner.nextInt();
                if (marks[i] < 0 || marks[i] > 100) {
                    System.out.println("Error: Invalid marks for subject " + (i + 1) + ": " + marks[i] + " (allowed 0-100)");
                    scanner.nextLine();
                    return;
                }
            }
            scanner.nextLine();
            Student student = new Student(roll, name, marks);
            students[size++] = student;
            System.out.println("Student added successfully.");
        } catch (InvalidMarksException ime) {
            System.out.println("Error: " + ime.getMessage());
        } catch (InputMismatchException ime) {
            System.out.println("Error: Input mismatch. Marks must be integers.");
            scanner.nextLine();
        } catch (IllegalArgumentException iae) {
            System.out.println("Error: " + iae.getMessage());
        }
    }

    private void showStudentDetails() {
        try {
            System.out.print("Enter Roll Number to search: ");
            int roll = scanner.nextInt();
            scanner.nextLine();
            Student found = findByRoll(roll);
            found.displayResult();
            System.out.println("Search completed.");
        } catch (StudentNotFoundException snfe) {
            System.out.println(snfe.getMessage());
        } catch (InputMismatchException ime) {
            System.out.println("Error: Input mismatch. Roll number must be an integer.");
            scanner.nextLine();
        }
    }

    private Student findByRoll(int roll) {
        for (int i = 0; i < size; i++) {
            if (students[i].getRollNumber() == roll) return students[i];
        }
        throw new StudentNotFoundException(roll);
    }
}
