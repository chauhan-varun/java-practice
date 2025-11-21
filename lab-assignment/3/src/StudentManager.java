package src;

import java.util.HashMap;
import java.util.Map;

public class StudentManager implements RecordActions {
    private final Map<Integer, Student> records = new HashMap<>();

    @Override
    public synchronized void addStudent(Student student) throws Exception {
        try {
            if (student == null) throw new IllegalArgumentException("Student cannot be null");
            Integer roll = student.getRollNo();
            if (roll == null) throw new IllegalArgumentException("Roll number is required");
            if (records.containsKey(roll)) throw new IllegalArgumentException("Student with this roll already exists");

            Thread loader = new Thread(new Loader());
            loader.start();
            loader.join();

            records.put(roll, student);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new Exception("Operation interrupted", ie);
        } finally {
        }
    }

    @Override
    public synchronized void saveStudent(Integer rollNo) throws Exception {
        try {
            if (rollNo == null) throw new IllegalArgumentException("Roll number required for save");

            Thread loader = new Thread(new Loader(1200));
            loader.start();
            loader.join();

            if (!records.containsKey(rollNo)) {
                throw new StudentNotFoundException("Student with roll " + rollNo + " not found.");
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new Exception("Save interrupted", ie);
        } finally {
        }
    }

    @Override
    public synchronized Student findStudent(Integer rollNo) throws StudentNotFoundException {
        if (rollNo == null) throw new IllegalArgumentException("Roll number required");
        Student s = records.get(rollNo);
        if (s == null) throw new StudentNotFoundException("Student with roll " + rollNo + " not found.");
        return s;
    }

    @Override
    public synchronized void displayStudent(Integer rollNo) throws StudentNotFoundException {
        Student s = findStudent(rollNo);
        System.out.println(s);
    }

    @Override
    public synchronized void removeStudent(Integer rollNo) throws StudentNotFoundException {
        if (!records.containsKey(rollNo)) throw new StudentNotFoundException("Student with roll " + rollNo + " not found.");
        records.remove(rollNo);
    }
}
