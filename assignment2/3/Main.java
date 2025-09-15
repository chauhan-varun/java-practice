import java.util.ArrayList;

class Department {
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

class Employee {
    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Developer extends Employee {
    private double overtimePay;

    public Developer(String id, String name, double salary, double overtimePay) {
        super(id, name, salary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + overtimePay;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        Department dept = new Department("Engineering");

        Manager m1 = new Manager("M001", "Varun", 8000, 2000);
        Manager m2 = new Manager("M002", "Ashish", 8500, 1000);
        Developer d1 = new Developer("D001", "Vicky", 6000, 500);
        Developer d2 = new Developer("D002", "Prem", 6200, 700);

        dept.addEmployee(m1);
        dept.addEmployee(m2);
        dept.addEmployee(d1);
        dept.addEmployee(d2);

        dept.displayEmployees();
        System.out.println("Total Monthly Expenditure: " + dept.calculateTotalExpenditure());
    }
}
