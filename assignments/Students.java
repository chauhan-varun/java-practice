class MarksOutOfRangeException extends Exception {
    public MarksOutOfRangeException(String message) {
        super(message);
    }
}
class Student {
    String name;
    int marks;
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
    public void validateMarks() 
    throws MarksOutOfRangeException {
        if (marks < 0 || marks > 100) {
            throw new MarksOutOfRangeException("Marks are out of range!");
        }else {

            System.out.println(name + "'s marks are valid: " + marks);
        }
    }
}
public class Students {
    public static void main(String[] args) {
        Student s1 = new Student("Lakshita", 105); 

        try {
            s1.validateMarks();
        } catch (MarksOutOfRangeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}