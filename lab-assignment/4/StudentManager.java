import java.util.*;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public void loadStudents() {
        students = FileUtil.loadStudents();
        if (!students.isEmpty()) {
            System.out.println("Loaded students from file:");
            displayAllStudents();
        }
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println();
        }
    }

    public void searchByName(String name) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println(student);
                System.out.println();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with name: " + name);
        }
    }

    public void deleteByName(String name) {
        Iterator<Student> iterator = students.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                deleted = true;
                System.out.println("Student deleted: " + name);
            }
        }
        if (!deleted) {
            System.out.println("No student found with name: " + name);
        }
    }

    public void sortByMarks() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMarks(), s1.getMarks());
            }
        });
        
        System.out.println("\nSorted Student List by Marks:");
        displayAllStudents();
    }

    public void sortByName() {
        Collections.sort(students);
        System.out.println("\nSorted Student List by Name:");
        displayAllStudents();
    }

    public void saveAndExit() {
        FileUtil.saveStudents(students);
        System.out.println("Goodbye!");
    }

    public List<Student> getStudents() {
        return students;
    }
}
