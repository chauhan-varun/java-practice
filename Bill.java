import java.util.Scanner;

public class Bill {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the number of units consumed: ");
        int units = scanner.nextInt();

        while (units > 0) {
            if (units > 0 && units <= 100) {
                System.out.println("Bill amount: Rs. " + units * 5);
            } else if (units > 100 && units <= 200) {
                System.out.println("Bill amount: Rs. " + units * 7);
            } else {
                System.out.println("Bill amount: Rs. " + units * 10);
            }

        }
        scanner.close();
    }
}
