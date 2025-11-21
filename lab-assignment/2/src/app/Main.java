package app;

import model.Student;
import service.StudentManager;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Student s1 = new Student(101, "Ankit", "ankit@mail.com", "B.Tech", 85.5);
        Student s2 = new Student(102, "Riya", "riya@mail.com", "M.Tech", 90.0);
        manager.addStudent(s1);
        manager.addStudent(s2);
        s1.displayInfo();
        s2.displayInfo("AI", true);
        System.out.println("[Note] Overloaded display method:");
        s1.displayInfo("Dr. Manish Kumar");
        FinalMessage fm = new FinalMessage();
        fm.show();
        Student temp = new Student(999, "Temp", "temp@mail.com", "Test", 50);
        temp = null;
        System.runFinalization();
        System.gc();
    }
}