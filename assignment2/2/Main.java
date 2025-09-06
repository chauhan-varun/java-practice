public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("S101", "Alice");
        Student s2 = new Student("S102", "Bob");
        Student s3 = new Student("S103", "Charlie");

        s1.addGrade("Math", 'A');
        s1.addGrade("Physics", 'B');
        s2.addGrade("Math", 'C');
        s2.addGrade("Chemistry", 'A');
        s3.addGrade("Math", 'B');
        s3.addGrade("Biology", 'D');

        Course c1 = new Course("MTH101", "Mathematics");
        Course c2 = new Course("PHY101", "Physics");

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c1.enrollStudent(s3);
        c2.enrollStudent(s1);
        c2.enrollStudent(s3);

        System.out.println("--- Mathematics Course ---");
        c1.displayEnrolledStudents();

        System.out.println("--- Physics Course ---");
        c2.displayEnrolledStudents();

        System.out.println("Dropping Bob (S102) from Mathematics...");
        c1.dropStudent("S102");

        System.out.println("--- Updated Mathematics Course ---");
        c1.displayEnrolledStudents();

        Department dept = new Department("Engineering");

        Manager m1 = new Manager("M001", "Alice", 80000, 10000);
        Manager m2 = new Manager("M002", "Bob", 85000, 12000);
        Developer d1 = new Developer("D001", "Charlie", 60000, 5000);
        Developer d2 = new Developer("D002", "Diana", 65000, 7000);

        dept.addEmployee(m1);
        dept.addEmployee(m2);
        dept.addEmployee(d1);
        dept.addEmployee(d2);

        dept.displayEmployees();
        System.out.printf("Total monthly expenditure: %.2f\n", dept.calculateTotalExpenditure());
    }
}
