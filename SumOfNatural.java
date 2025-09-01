import java.util.Scanner;

public class SumOfNatural {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int a = scanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + a + " natural numbers is: " + sum);
        scanner.close();
    }
}
