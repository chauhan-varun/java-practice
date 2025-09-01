public class Animal {
    int age;
    String name;
    String color;

    Animal(String name, String color, int age) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public void getAnimal() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color);
    }

    public static void main(String[] args) {
        Animal a = new Animal("Dog", "Black", 2);
        a.getAnimal();
    }
}
