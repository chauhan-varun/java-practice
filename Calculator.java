import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value 1: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value 2: ");
        int b = scanner.nextInt();
        System.out.print("Enter the operator: ");
        String operator = scanner.next();
        int result = 0;
        if (operator.equals("+")) {
            result = a + b;
        } else if (operator.equals("-")) {
            result = a - b;
        } else if (operator.equals("*")) {
            result = a * b;
        } else if (operator.equals("/")) {
            result = a / b;
        } else {
            System.out.println("Invalid operator");
        }
        System.out.println("Result: " + result);
        scanner.close();
    }
}
