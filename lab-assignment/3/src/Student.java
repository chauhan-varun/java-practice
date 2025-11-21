package src;

public class Student {
    private Integer rollNo;
    private String name;
    private String email;
    private String course;
    private Double marks;

    public Student(Integer rollNo, String name, String email, String course, Double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public Integer getRollNo() { return rollNo; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public Double getMarks() { return marks; }

    public String getGrade() {
        double m = marks.doubleValue();
        if (m >= 85.0) return "A";
        if (m >= 70.0) return "B";
        if (m >= 50.0) return "C";
        return "D";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Roll No: ").append(rollNo).append('\n');
        sb.append("Name: ").append(name).append('\n');
        sb.append("Email: ").append(email).append('\n');
        sb.append("Course: ").append(course).append('\n');
        sb.append("Marks: ").append(marks).append('\n');
        sb.append("Grade: ").append(getGrade());
        return sb.toString();
    }
}
