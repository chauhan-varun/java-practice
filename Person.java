import java.util.Scanner;

class Person {
    protected String name;
    protected int age;
    
    public Person() {
        this.name = "";
        this.age = 0;
    }
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void inputDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter age: ");
        this.age = scanner.nextInt();
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
