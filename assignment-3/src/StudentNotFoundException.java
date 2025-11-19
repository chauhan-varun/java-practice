public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(int rollNumber) {
        super("Student with roll number " + rollNumber + " not found.");
    }
}
