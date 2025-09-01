
import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("=== Simple Interest Calculator ===");

        // Loop for multiple customers
        do {
            System.out.print("\nEnter Principal amount: ");
            double principal = scanner.nextDouble();

            System.out.print("Enter Rate of Interest (% per year): ");
            double rate = scanner.nextDouble();

            System.out.print("Enter Time in years: ");
            int years = scanner.nextInt();

            // Input validation
            if (principal <= 0 || rate <= 0 || years <= 0) {
                System.out.println("❌ Invalid input! All values must be positive.");
            } else {
                double simpleInterest = (principal * rate * years) / 100;
                System.out.println("✅ Simple Interest = " + simpleInterest);
            }

            System.out.print("\nDo you want to calculate for another customer? (yes/no): ");
            choice = scanner.next().toLowerCase();

        } while (choice.equals("yes"));

        System.out.println("\nThank you for using the Simple Interest Calculator!");
        scanner.close();
    }
}
