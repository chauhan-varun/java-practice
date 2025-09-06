public class Developer extends Employee {
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
