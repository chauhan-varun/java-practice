public class Manager extends Employee {
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
