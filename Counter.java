
import java.util.Scanner;

public class EvenOddCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evenCount = 0;
        int oddCount = 0;

        System.out.print("Enter how many numbers you want to input (N): ");
        int N = scanner.nextInt();

        // Loop to take N numbers
        for (int i = 1; i <= N; i++) {
            System.out.print("Enter number " + i + ": ");
            int num = scanner.nextInt();

            // Even or odd check
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Output result
        System.out.println("\nTotal even numbers: " + evenCount);
        System.out.println("Total odd numbers: " + oddCount);

        scanner.close();
    }
}
