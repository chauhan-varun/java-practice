package src;

public interface RecordActions {
    void addStudent(Student student) throws Exception;
    void saveStudent(Integer rollNo) throws Exception;
    Student findStudent(Integer rollNo) throws StudentNotFoundException;
    void displayStudent(Integer rollNo) throws StudentNotFoundException;
    void removeStudent(Integer rollNo) throws StudentNotFoundException;
}
