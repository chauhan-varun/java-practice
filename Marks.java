import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the marks of Subject DSA: ");
        int a = scanner.nextInt();
        System.out.print("Enter the marks of Subject OOP: ");
        int b = scanner.nextInt();
        System.out.print("Enter the marks of Subject DBMS: ");
        int c = scanner.nextInt();
        double percentage = ((a + b + c) / 300.0) * 100;

        if (percentage >= 90 && percentage <= 100) {
            System.out.println("Grade: A");
        } else if (percentage >= 80 && percentage < 90) {
            System.out.println("Grade: B");
        } else if (percentage >= 70 && percentage < 80) {
            System.out.println("Grade: C");
        } else if (percentage >= 60 && percentage < 70) {
            System.out.println("Grade: D");
        } else if (percentage >= 50 && percentage < 60) {
            System.out.println("Grade: E");
        } else {
            System.out.println("Grade: F");

        }
        scanner.close();
    }
}
