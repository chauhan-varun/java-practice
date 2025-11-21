import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String FILE_NAME = "students.txt";

    public static List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int rollNo = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String email = parts[2].trim();
                    String course = parts[3].trim();
                    double marks = Double.parseDouble(parts[4].trim());
                    students.add(new Student(rollNo, name, email, course, marks));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing student data: " + e.getMessage());
        }

        return students;
    }

    public static void saveStudents(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students) {
                writer.write(student.toFileFormat());
                writer.newLine();
            }
            System.out.println("Student data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public static void displayFileAttributes() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("\n--- File Attributes ---");
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());
            System.out.println("Last Modified: " + new java.util.Date(file.lastModified()));
        }
    }

    public static void demonstrateRandomAccess() {
        try (RandomAccessFile raf = new RandomAccessFile(FILE_NAME, "r")) {
            System.out.println("\n--- Random Access File Demo ---");
            System.out.println("File Length: " + raf.length() + " bytes");
            
            if (raf.length() > 0) {
                raf.seek(0);
                String firstLine = raf.readLine();
                System.out.println("First Record: " + firstLine);
                
                long midPoint = raf.length() / 2;
                raf.seek(midPoint);
                raf.readLine();
                String midLine = raf.readLine();
                if (midLine != null) {
                    System.out.println("Mid Record: " + midLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Error in random access: " + e.getMessage());
        }
    }
}
