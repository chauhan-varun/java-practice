import java.util.ArrayList;

public class Department {
    private String departmentName;
    private ArrayList<Employee> employees;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public double calculateTotalExpenditure() {
        double total = 0;
        for (Employee e : employees) {
            total += e.getSalary();
        }
        return total;
    }

    public void displayEmployees() {
        System.out.println("Department: " + departmentName);
        for (Employee e : employees) {
            System.out.println(e.getName() + " (ID: " + e.getId() + ") - Salary: " + e.getSalary());
        }
    }
}
