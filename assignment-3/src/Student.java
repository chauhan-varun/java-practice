public class Student {
    private final int rollNumber;
    private final String studentName;
    private final int[] marks;

    public Student(int rollNumber, String studentName, int[] marks) throws InvalidMarksException {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null/empty");
        }
        this.rollNumber = rollNumber;
        this.studentName = studentName.trim();
        this.marks = marks;
        validateMarks();
    }

    public int getRollNumber() { return rollNumber; }
    public String getStudentName() { return studentName; }
    public int[] getMarks() { return marks; }

    public void validateMarks() throws InvalidMarksException {
        if (marks == null) {
            throw new InvalidMarksException("Marks array is null");
        }
        if (marks.length != 3) {
            throw new InvalidMarksException("Marks array must contain exactly 3 subjects; found " + marks.length);
        }
        for (int i = 0; i < marks.length; i++) {
            int m = marks[i];
            if (m < 0 || m > 100) {
                throw new InvalidMarksException("Invalid marks for subject " + (i + 1) + ": " + m + " (allowed 0-100)");
            }
        }
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) { sum += m; }
        return sum / 3.0;
    }

    public String getResultStatus() {
        for (int m : marks) {
            if (m < 40) return "Fail";
        }
        return calculateAverage() >= 40.0 ? "Pass" : "Fail";
    }

    public void displayResult() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Student Name: " + studentName);
        System.out.print("Marks: ");
        for (int m : marks) {
            System.out.print(m + " ");
        }
        System.out.println();
        System.out.println("Average: " + calculateAverage());
        System.out.println("Result: " + getResultStatus());
    }
}
