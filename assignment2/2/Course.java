import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void dropStudent(String studentId) {
        enrolledStudents.removeIf(s -> s.getStudentId().equals(studentId));
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName + " (" + courseCode + ")");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student s : enrolledStudents) {
                s.displayStudentDetails();
            }
        }
        System.out.println();
    }
}
