package model;

public class Student extends Person {
    private int rollNo;
    private String course;
    private double marks;
    private String grade;

    public Student(int rollNo, String name, String email, String course, double marks) {
        super(name, email);
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        this.grade = computeGrade(marks);
    }

    private String computeGrade(double m) {
        if (m >= 90) return "A";
        if (m >= 80) return "B";
        if (m >= 70) return "C";
        if (m >= 60) return "D";
        return "F";
    }

    public int getRollNo() { return rollNo; }
    public String getCourse() { return course; }
    public double getMarks() { return marks; }
    public String getGrade() { return grade; }

    public void setCourse(String course) { this.course = course; }
    public void setMarks(double marks) { this.marks = marks; this.grade = computeGrade(marks); }

    @Override
    public void displayInfo() {
        System.out.println("Student Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
    }

    public void displayInfo(String instructor) {
        System.out.println("Student Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println(instructor);
        System.out.println("Course: " + course);
    }

    public void displayInfo(String researchArea, boolean research) {
        System.out.println("Student Info:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Research Area: " + researchArea);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called before object is garbage collected.");
        super.finalize();
    }
}