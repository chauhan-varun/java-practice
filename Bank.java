public class Bank {
    private String accountHolderName;
    private String accountNumber;

    public Bank(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}

public class Main {

    public static void main(String[] args) {
        // Example usage
        Bank account = new Bank("John Doe", "123456789");
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
    }

}
