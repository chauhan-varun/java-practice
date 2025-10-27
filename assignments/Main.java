import java.util.ArrayList;

class Employee {
    private String employeeId;
    private String name;
    private int salary;

    Employee(String employeeId, String name, int salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    private double bonus;

    Manager(String employeeId, String name, int salary, double bonus) {
        super(employeeId, name, salary);
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        double totalSalary = super.getSalary() + bonus;
        return (int) totalSalary;
    }

}

class Developer extends Employee {
    private int overtimepay;

    Developer(String employeeId, String name, int salary, int overtimepay) {
        super(employeeId, name, salary);
        this.overtimepay = overtimepay;
    }

    @Override
    public int getSalary() {
        int totalSalary = super.getSalary() + overtimepay;
        return totalSalary;
    }
}

class Department {
    private String departmentName;
    private ArrayList<Employee> employees = new ArrayList<>();

    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void calculateTotalSalary() {
        int total = 0;
        for (Employee e : employees) {
            total += e.getSalary();
        }
        System.out.println("Total Salary: " + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("E001", "John", 50000);
        Manager m1 = new Manager("M001", "Alice", 70000, 10000);
        Developer d1 = new Developer("D001", "Bob", 60000, 5000);

        Department dept = new Department("IT");
        dept.addEmployee(e1);
        dept.addEmployee(m1);
        dept.addEmployee(d1);

        dept.calculateTotalSalary();
    }
}
