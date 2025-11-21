package model;

import java.util.Scanner;

public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student() {
        super();
    }

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        this.grade = calculateGrade();
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade();
    }

    public String getGrade() {
        return grade;
    }

    public void inputDetails(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Enter Roll No: ");
        this.rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        this.name = scanner.nextLine().trim();
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        System.out.print("Enter Email: ");
        this.email = scanner.nextLine().trim();
        if (this.email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        System.out.print("Enter Course: ");
        this.course = scanner.nextLine().trim();
        if (this.course.isEmpty()) {
            throw new IllegalArgumentException("Course cannot be empty");
        }

        System.out.print("Enter Marks: ");
        this.marks = scanner.nextDouble();
        scanner.nextLine();

        if (this.marks < 0 || this.marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }

        this.grade = calculateGrade();
    }

    public void displayDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + grade);
    }

    @Override
    public void displayInfo() {
        displayDetails();
    }

    public String calculateGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public String toFileString() {
        return rollNo + "|" + name + "|" + email + "|" + course + "|" + marks;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split("\\|");
        int rollNo = Integer.parseInt(parts[0]);
        String name = parts[1];
        String email = parts[2];
        String course = parts[3];
        double marks = Double.parseDouble(parts[4]);
        return new Student(rollNo, name, email, course, marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                ", grade='" + grade + '\'' +
                '}';
    }
}
