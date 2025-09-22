interface PersonalDetails {

    void getPersonalDetails();
}

interface WorkDetails {
    void getWorkDetails();
}

public class Employee implements PersonalDetails, WorkDetails {
    private String name;
    private int age;
    private String Address;

    private Number EmployeeID;
    private String Department;
    private String role;

    Employee(String name, int age, String Address, Number EmployeeID, String Department, String role) {
        this.name = name;
        this.age = age;
        this.Address = Address;
        this.EmployeeID = EmployeeID;
        this.Department = Department;
        this.role = role;
    }

    @Override
    public void getPersonalDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + Address);
    }

    @Override
    public void getWorkDetails() {
        System.out.println("Employee ID: " + EmployeeID);
        System.out.println("Department: " + Department);
        System.out.println("Role: " + role);
    }

    public static void main(String args[]) {
        Employee emp = new Employee("John Doe", 30, "123 Main St", 1001, "IT", "Developer");
        emp.getPersonalDetails();
        emp.getWorkDetails();
    }
}
