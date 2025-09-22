class Animal {
    int age;
    String name;
    String color;

    final void getAnimal() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
    }

    void setAnimal(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

}

class Dog extends Animal {

    // void getAnimal() {
    // System.out.println("Dog Name: " + name);
    // System.out.println("Dog Age: " + age);
    // System.out.println("Dog Color: " + color);
    // }

    void setAnimal(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }
}

public class Main {

    public static void main(String[] args) {
        Animal a = new Animal();
        a.getAnimal();
        Dog dog = new Dog();
        dog.setAnimal(5, "Buddy", "Brown");
        dog.getAnimal();
    }
}
