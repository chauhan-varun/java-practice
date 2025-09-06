import java.util.HashMap;

public class Student {
    private String studentId;
    private String name;
    private HashMap<String, Character> grades;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, char grade) {
        grades.put(subject, grade);
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double totalPoints = 0;
        for (char grade : grades.values()) {
            switch (grade) {
                case 'A': totalPoints += 4; break;
                case 'B': totalPoints += 3; break;
                case 'C': totalPoints += 2; break;
                case 'D': totalPoints += 1; break;
                case 'F': totalPoints += 0; break;
            }
        }
        return totalPoints / grades.size();
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Grades:");
        for (String subject : grades.keySet()) {
            System.out.println("  " + subject + ": " + grades.get(subject));
        }
        System.out.printf("GPA: %.2f\n", calculateGPA());
        System.out.println();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}
