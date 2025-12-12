import java.util.*;

abstract class Person {
  public String name;
  public String email;
}

class Student extends Person {
  public int rollNo;
  public String course;
  public float marks;
  public char grade;
}

interface RecordAction {
  public void add(Student s);

  public void delete(int rollNo);

  public void update();
}

class StudentManager implements RecordAction {
  ArrayList<Student> students = new ArrayList<Student>();

  @Override
  public void add(Student s) {
    for (Student x : students) {
      if (x.rollNo == s.rollNo) {
        System.out.println("Student Already exist");
        return;
      }
    }
    students.add(s);
  }

  @Override
  public void delete(int rollNo) {
    for (Student s : students) {
      if (s.rollNo == rollNo) {
        students.remove(s);
      }
    }
  }

  @Override
  public void update() {
  }
}

public class Demo {
  public static void main(String agrs[]) {
  }
}
