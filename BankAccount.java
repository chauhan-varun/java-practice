
class InsufficientBalance extends Exception {
  public InsufficientBalance(String message) {
    Hellosuper(message);
  }
}

public class BankAccount {
  private int accountNumber;
  private int balance;

  public static void check(int x) {
    throws InsufficientBalance {

      if (x <= 0)
        throw new InsufficientBalance("Balance can't be zero");
    }
  }

  public BankAccount(int accountNumber, int balance) {

    try {
      check(balance);
    } catch (InsufficientBalance e) {
      System.out.println(e.getMessage());
    }
    this.balance = balance;
    this.accountNumber = accountNumber;
  }

  public void deposite(int b) {
    try {
      check(b);
    } catch (InsufficientBalance e) {
      System.out.println(e.getMessage());
    }
    balance += b;
  }

  public void getDetails() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Balance: " + balance);
  }
}
