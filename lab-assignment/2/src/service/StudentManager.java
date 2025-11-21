package service;

import model.Student;
import java.util.*;

public class StudentManager implements RecordActions {
    private final Map<Integer, Student> studentMap = new HashMap<>();
    private final List<Student> studentList = new ArrayList<>();

    @Override
    public boolean addStudent(Student s) {
        if (studentMap.containsKey(s.getRollNo())) return false;
        studentMap.put(s.getRollNo(), s);
        studentList.add(s);
        return true;
    }

    @Override
    public boolean deleteStudent(int rollNo) {
        Student removed = studentMap.remove(rollNo);
        if (removed == null) return false;
        studentList.removeIf(st -> st.getRollNo() == rollNo);
        return true;
    }

    @Override
    public boolean updateStudent(int rollNo, Student updated) {
        if (!studentMap.containsKey(rollNo)) return false;
        studentMap.put(rollNo, updated);
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getRollNo() == rollNo) {
                studentList.set(i, updated);
                break;
            }
        }
        return true;
    }

    @Override
    public Student searchStudent(int rollNo) {
        return studentMap.get(rollNo);
    }

    @Override
    public List<Student> viewAllStudents() {
        return new ArrayList<>(studentList);
    }

    @Override
    public List<Student> sortStudentsByMarks() {
        List<Student> copy = new ArrayList<>(studentList);
        copy.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        return copy;
    }

    @Override
    public List<Student> sortStudentsByName() {
        List<Student> copy = new ArrayList<>(studentList);
        copy.sort(Comparator.comparing(Student::getName));
        return copy;
    }
}