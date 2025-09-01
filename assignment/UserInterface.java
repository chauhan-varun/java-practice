import java.util.Scanner;

public class UserInterface {
    private static final int MAX_ACCOUNTS = 100;
    private static Account[] accounts = new Account[MAX_ACCOUNTS];
    private static int accountCount = 0;
    private static int nextAccountNumber = 1001;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking Application!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void createAccount() {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Cannot create more accounts.");
            return;
        }
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        Account acc = new Account(nextAccountNumber, name, amount, email, phone);
        accounts[accountCount++] = acc;
        System.out.println("Account created successfully with Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    public static Account findAccount(int accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    public static void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        scanner.nextLine();
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();
        scanner.nextLine();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter new email address: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = scanner.nextLine();
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found.");
        }
    }
}
