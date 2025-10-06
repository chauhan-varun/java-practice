class Employee {

    private int ID;
    private String name;
    private int age;
    private static int nextId = 1;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = nextId++;
    }

    public void show() {
        System.out.println("Id=" + ID + "\nName=" + name
                + "\nAge=" + age);
    }

    public void showNextId() {
        System.out.println("Next employee id will be="
                + nextId);
    }
}

class gc {
    public static void main(String args[]) {
    }
}

class UseEmployee {
    public static void main(String[] args) {

        Employee E = new Employee("GFG1", 56);
        Employee F = new Employee("GFG2", 45);
        Employee G = new Employee("GFG3", 25);
        E.show();
        F.show();
        G.show();
        E.showNextId();
        F.showNextId();
        G.showNextId();

        {
            Employee X = new Employee("GFG4", 23);
            Employee Y = new Employee("GFG5", 21);
            X.show();
            Y.show();
            X.showNextId();
            Y.showNextId();
        }
        E.showNextId();
    }
}
