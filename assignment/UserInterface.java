import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Calculator calculator = new Calculator();

    private void performAddition() {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.println("Result: " + calculator.add(a, b));
    }

    private void performSubtraction() {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.println("Result: " + calculator.subtract(a, b));
    }

    private void performMultiplication() {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.println("Result: " + calculator.multiply(a, b));
    }

    private void performDivision() {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        try {
            System.out.println("Result: " + calculator.divide(a, b));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.showMenu();
    }

}
