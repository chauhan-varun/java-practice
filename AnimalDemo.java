class Animal {
    protected String name;
    
    public Animal() {
        this.name = "Unknown Animal";
    }
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void sound() {
        System.out.println(name + " makes a generic animal sound");
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal {
    
    public Dog() {
        super("Dog");
    }
    
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}

class Cat extends Animal {
    
    public Cat() {
        super("Cat");
    }
    
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void sound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        System.out.println("=== Dynamic Method Dispatch Demo ===\n");
        
        Animal[] animals = new Animal[5];
        
        animals[0] = new Dog("Buddy");
        animals[1] = new Cat("Whiskers");
        animals[2] = new Dog("Max");
        animals[3] = new Cat("Luna");
        animals[4] = new Dog("Charlie");
        
        System.out.println("Calling sound() method using dynamic method dispatch:");
        System.out.println("===================================================");
        
        for (int i = 0; i < animals.length; i++) {
            System.out.print((i + 1) + ". ");
            animals[i].sound(); 
        }
        
        System.out.println("\n=== Enhanced for loop demonstration ===");
        
        int count = 1;
        for (Animal animal : animals) {
            System.out.print(count + ". ");
            animal.sound(); 
            count++;
        }
        
        System.out.println("\n=== Individual object demonstration ===");
        
        Animal genericAnimal = new Animal("Generic Animal");
        Animal dogRef = new Dog("Rocky");
        Animal catRef = new Cat("Mittens");
        
        System.out.println("Generic Animal:");
        genericAnimal.sound();
        
        System.out.println("\nDog object with Animal reference:");
        dogRef.sound(); 
        
        System.out.println("\nCat object with Animal reference:");
        catRef.sound();
        
        System.out.println("\n=== Type checking demonstration ===");
        
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                System.out.println(animal.getName() + " is a Dog");
            } else if (animal instanceof Cat) {
                System.out.println(animal.getName() + " is a Cat");
            }
        }
    }
}
