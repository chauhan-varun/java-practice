
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    int balance = 5000; 

    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(int amount) 
    throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! You have only ₹" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}


public class Customs {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.showBalance();
        account.deposit(2000);

        try {
            account.withdraw(8000); 
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        account.showBalance();
    }
}
