package service;

import model.Student;
import util.StudentNotFoundException;

public interface RecordActions {
    
    void addStudent(Student student) throws IllegalArgumentException;
    
    void deleteStudent(String name) throws StudentNotFoundException;
    
    void updateStudent(int rollNo, Student updatedStudent) throws StudentNotFoundException;
    
    Student searchStudent(String name) throws StudentNotFoundException;
    
    void viewAllStudents();
}
