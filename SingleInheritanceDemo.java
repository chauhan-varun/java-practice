import java.util.Scanner;

class Student extends Person {
    private String rollNumber;

    public Student() {
        super();
        this.rollNumber = "";
    }

    public Student(String name, int age, String rollNumber) {
        super(name, age);
        this.rollNumber = rollNumber;
    }

    @Override
    public void inputDetails() {
        super.inputDetails();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter roll number: ");
        this.rollNumber = scanner.nextLine();
        scanner.close();
    }

    @Override
    public void displayDetails() {
        System.out.println("=== Student Details ===");
        super.displayDetails();
        System.out.println("Roll Number: " + rollNumber);
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}

public class SingleInheritanceDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Single Inheritance Demo ===");
        System.out.println("Creating a Student object...\n");

        Student student = new Student();

        System.out.println("Please enter student details:");
        student.inputDetails();

        System.out.println("\nStudent information:");
        student.displayDetails();

        System.out.println("\n=== Demo with parameterized constructor ===");

        Student student2 = new Student("Alice Johnson", 20, "CS2023001");
        System.out.println("\nStudent created using constructor:");
        student2.displayDetails();

        scanner.close();
    }
}
