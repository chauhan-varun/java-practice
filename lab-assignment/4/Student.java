public class Student implements Comparable<Student> {
    private int rollNo;
    private String name;
    private String email;
    private String course;
    private double marks;

    public Student(int rollNo, String name, String email, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.email = email;
        this.course = course;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    public String toFileFormat() {
        return rollNo + "," + name + "," + email + "," + course + "," + marks;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + "\n" +
               "Name: " + name + "\n" +
               "Email: " + email + "\n" +
               "Course: " + course + "\n" +
               "Marks: " + marks;
    }
}
