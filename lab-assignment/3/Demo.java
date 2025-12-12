import java.util.*;
import java.io.*;

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

class Loader implements Runnable {
  public int time;

  public Loader() {
    this.time = 500;
  }

  public Loader(int time) {
    this.time = time;
  }

  public void run() {
    try {
      System.out.println("Loading...");
      Thread.sleep(this.time);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}

class StudentNotFoundException extends Exception {
  public StudentNotFoundException(String message) {
    super(message);
  }
}

class StudentManger {
  ArrayList<Student> students;
  Map<Integer, Student> studentMap;

  public StudentManger() {
    this.students = new ArrayList<Student>();
    this.studentMap = new HashMap<Integer, Student>();
  }

  public void addStudent() {
    File file = new File("students.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] details = line.split(",");
        Student student = new Student();
        student.rollNo = Integer.parseInt(details[0]);
        student.name = details[1];
        student.email = details[2];
        student.course = details[3];
        student.marks = Float.parseFloat(details[4]);
        student.grade = details[5].charAt(0);
        this.students.add(student);
        this.studentMap.put(student.rollNo, student);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }

  public Student getStudent(int rollNo) {
    try {
      Thread loaderThread = new Thread(new Loader(500));
      loaderThread.start();
      loaderThread.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    if (!this.studentMap.containsKey(rollNo)) {
      try {
        throw new StudentNotFoundException("Student with roll no " + rollNo + " not found.");
      } catch (StudentNotFoundException e) {
        System.out.println(e.getMessage());
        return null;
      }
    }
    return this.studentMap.get(rollNo);
  }

  public ArrayList<Student> getAllStudents() {
    try {
      Thread loaderThread = new Thread(new Loader(1500));
      loaderThread.start();
      loaderThread.join();
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    return this.students;
  }
}

public class Demo {
  public static void main(String[] args) {
  }
}
