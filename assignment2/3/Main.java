public class Main {
    public static void main(String[] args) {
        Department dept = new Department("Engineering");

        Manager m1 = new Manager("M001", "Alice", 8000, 2000);
        Manager m2 = new Manager("M002", "Bob", 8500, 1500);
        Developer d1 = new Developer("D001", "Charlie", 6000, 500);
        Developer d2 = new Developer("D002", "Diana", 6200, 700);

        dept.addEmployee(m1);
        dept.addEmployee(m2);
        dept.addEmployee(d1);
        dept.addEmployee(d2);

        dept.displayEmployees();
        System.out.println("Total Monthly Expenditure: " + dept.calculateTotalExpenditure());
    }
}
