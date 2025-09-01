import java.util.Scanner;

public class Atm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 1000;
        System.out.println("Available balance: " + balance);

        while (balance > 0) {
            System.out.print("Enter the amount to withdraw: ");
            int amount = scanner.nextInt();
            if (amount > balance) {
                System.out.println("Insufficient balance");
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful");
                System.out.println("Available balance: " + balance);
            }
        }
        scanner.close();
    }
}
