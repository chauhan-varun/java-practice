import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadStudents();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput(scanner, "Enter choice: ");

            switch (choice) {
                case 1:
                    addStudent(scanner, manager);
                    break;
                case 2:
                    System.out.println("\n--- All Students ---");
                    manager.displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    manager.searchByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteByName(deleteName);
                    break;
                case 5:
                    manager.sortByMarks();
                    break;
                case 6:
                    manager.saveAndExit();
                    FileUtil.displayFileAttributes();
                    FileUtil.demonstrateRandomAccess();
                    running = false;
                    break;
                case 7:
                    manager.sortByName();
                    break;
                case 8:
                    FileUtil.displayFileAttributes();
                    break;
                case 9:
                    FileUtil.demonstrateRandomAccess();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
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
        System.out.println("7. Sort by Name");
        System.out.println("8. Display File Attributes");
        System.out.println("9. Random Access File Demo");
    }

    private static void addStudent(Scanner scanner, StudentManager manager) {
        int rollNo = getIntInput(scanner, "Enter Roll No: ");
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        
        double marks = getDoubleInput(scanner, "Enter Marks: ");
        
        Student student = new Student(rollNo, name, email, course, marks);
        manager.addStudent(student);
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
