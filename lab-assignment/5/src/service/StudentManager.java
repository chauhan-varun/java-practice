package service;

import model.Student;
import util.StudentNotFoundException;
import util.Loader;

import java.io.*;
import java.util.*;

public class StudentManager implements RecordActions {
    private List<Student> studentList;
    private Map<Integer, Student> studentMap;
    private static final String FILE_PATH = "students.txt";

    public StudentManager() {
        studentList = new ArrayList<>();
        studentMap = new HashMap<>();
        loadFromFile();
    }

    @Override
    public void addStudent(Student student) throws IllegalArgumentException {
        if (studentMap.containsKey(student.getRollNo())) {
            throw new IllegalArgumentException("Student with Roll No " + student.getRollNo() + " already exists!");
        }

        Thread loader = new Thread(new Loader("Adding student"));
        loader.start();
        try {
            loader.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        studentList.add(student);
        studentMap.put(student.getRollNo(), student);
        System.out.println("Student added successfully!");
    }

    @Override
    public void deleteStudent(String name) throws StudentNotFoundException {
        Student studentToDelete = null;

        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                studentToDelete = student;
                break;
            }
        }

        if (studentToDelete == null) {
            throw new StudentNotFoundException("Student with name '" + name + "' not found!");
        }

        Thread loader = new Thread(new Loader("Deleting student"));
        loader.start();
        try {
            loader.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        studentList.remove(studentToDelete);
        studentMap.remove(studentToDelete.getRollNo());
        System.out.println("Student record deleted.");
    }

    @Override
    public void updateStudent(int rollNo, Student updatedStudent) throws StudentNotFoundException {
        if (!studentMap.containsKey(rollNo)) {
            throw new StudentNotFoundException("Student with Roll No " + rollNo + " not found!");
        }

        Thread loader = new Thread(new Loader("Updating student"));
        loader.start();
        try {
            loader.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        Student oldStudent = studentMap.get(rollNo);
        studentList.remove(oldStudent);

        studentList.add(updatedStudent);
        studentMap.put(rollNo, updatedStudent);
        System.out.println("Student record updated successfully!");
    }

    @Override
    public Student searchStudent(String name) throws StudentNotFoundException {
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        throw new StudentNotFoundException("Student with name '" + name + "' not found!");
    }

    @Override
    public void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\n========== All Students ==========");
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            student.displayDetails();
            System.out.println("----------------------------------");
        }
    }

    public void sortByMarks() {
        if (studentList.isEmpty()) {
            System.out.println("No student records to sort.");
            return;
        }

        List<Student> sortedList = new ArrayList<>(studentList);

        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getMarks(), s1.getMarks());
            }
        });

        System.out.println("\nSorted Student List by Marks:");
        System.out.println("========================================");
        Iterator<Student> iterator = sortedList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            student.displayDetails();
            System.out.println("----------------------------------");
        }
    }

    public void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("No existing student records file found. Starting fresh.");
            return;
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                try {
                    Student student = Student.fromFileString(line);
                    studentList.add(student);
                    studentMap.put(student.getRollNo(), student);
                    count++;
                } catch (Exception e) {
                    System.out.println("Error parsing line: " + line);
                }
            }

            System.out.println("Loaded " + count + " student records from file.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public void saveToFile() {
        BufferedWriter writer = null;
        try {
            Thread loader = new Thread(new Loader("Saving records"));
            loader.start();
            loader.join();

            writer = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Student student : studentList) {
                writer.write(student.toFileString());
                writer.newLine();
            }

            System.out.println("Student records saved successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Map<Integer, Student> getStudentMap() {
        return studentMap;
    }
}
