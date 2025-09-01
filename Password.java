import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the password of varun");

        int chances = 3;
        while (chances > 0) {
            System.out.println("You have " + chances + " chances left");
            String password = scanner.nextLine();

            if (password.equals("password")) {
                System.out.println("Access granted");
                break;
            } else {
                System.out.println("Access denied");
            }
            chances--;
        }
        scanner.close();
    }
}
