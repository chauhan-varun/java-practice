import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Temperature type: ");
        String temp = scanner.nextLine();
        System.out.print("Enter the value: ");
        double value = scanner.nextDouble();

        if(temp.equals("Celsius")) {
            double fahrenheit = (value * 9 / 5) + 32;
            System.out.println(value + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit");
        } else if (temp.equals("Fahrenheit")) {
            double celsius = (value - 32) * 5 / 9;
            System.out.println(value + " degrees Fahrenheit is equal to " + celsius + " degrees Celsius");
        } else 
            System.out.println("Invalid temperature type");
        scanner.close();
    }
}
