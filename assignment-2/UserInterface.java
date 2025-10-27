import java.util.Scanner;

public class UserInterface {

    calculator calc = new calculator();
    Scanner sc = new Scanner(System.in);

    public void performAddition() {
        System.out.println("Enter the choice for addition: ");
        int choice = sc.nextInt();
        System.out.println("1: add two integers");
        System.out.println("2. add two doubles");
        System.out.println("3. add three integers");
        switch (choice) {
            case 1:
                System.out.println("Enter two integers: ");
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println("result is: " + calc.add(a, b));
                break;

            case 2:
                System.out.println("Enter two doubles: ");
                double h = sc.nextDouble();
                double g = sc.nextDouble();
                System.out.println("result is:" + calc.add(h, g));
                break;

            case 3:
                System.out.println("Enter three integers: ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                System.out.println("result is: " + calc.add(x, y, z));

        }
    }

    public void performSubtraction() {
        System.out.println("Enter two integers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Result is: " + calc.subtract(a, b));
    }

    public void performMultiplication() {
        System.out.println("enter two doubles: ");
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        System.out.println("Result is " + calc.multiply(c, d));
    }

    public void performDivision() {
        System.out.println("enter the two integers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("Result is: " + calc.divide(x, y));
    }

    public void mainMenu() {
        int choice;
        System.out.println("Calculator Details: ");

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("5. Division");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();

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
                System.out.println("Exiting");
            default:
                System.out.println("Invalid choice");

        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.mainMenu();
    }
}
