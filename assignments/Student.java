import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Student {
    private String studentId;
    private String name;
    private HashMap<String, Character> grades = new HashMap<>();

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void addGrade(String subject, Character grade) {
        grades.put(subject, grade);
    }

    public void calculateGrade() {
        int A = 4, B = 3, C = 2, D = 1, F = 0;
        int average = (A + B + C + D + F) / 5;
        System.out.println(average);
    }

    public void getDetails() {
        System.out.println(studentId);
        System.out.println(name);
        for (Map.Entry<String, Character> e : grades.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }

    }

    public String getStudentId() {
        return studentId;
    }

    public static void main(String[] args) {
        Student s1 = new Student("S001", "Alice");
        s1.addGrade("Math", 'A');
        s1.addGrade("Science", 'B');
        s1.getDetails();
        s1.calculateGrade();

        Course c1 = new Course("CSE101", "Introduction to Computer Science");
        c1.enrollStudent(s1);
        c1.getCourseDetails();
        c1.getAllStudents();
        c1.dropStudent("S001");
        c1.getAllStudents();

    }
}

class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<Student> students = new ArrayList<>();

    Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public void enrollStudent(Student student) {
        students.add(student);
    }

    public void dropStudent(String studentId) {
        students.removeIf(s -> s.getStudentId().equals(studentId));
    }

    public void getAllStudents() {
        for (Student s : students) {
            s.getDetails();
        }
    }

    public void getCourseDetails() {
        System.out.println(courseCode);
        System.out.println(courseName);
    }
}
