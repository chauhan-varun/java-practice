import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        System.out.println("Enter your age: ");
        int age = scanner.nextInt();
        System.out.println("You are " + age + "years old");
        scanner.close();
    }
}
