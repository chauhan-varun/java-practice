package service;

import model.Student;
import java.util.List;

public interface RecordActions {
    boolean addStudent(Student s);
    boolean deleteStudent(int rollNo);
    boolean updateStudent(int rollNo, Student updated);
    Student searchStudent(int rollNo);
    List<Student> viewAllStudents();
    List<Student> sortStudentsByMarks();
    List<Student> sortStudentsByName();
}