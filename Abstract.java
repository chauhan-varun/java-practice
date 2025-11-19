abstract class Shape {
    abstract void area();

    final void display() {
        System.out.println("This is a shape.");
    }

    abstract double calculateArea(int r);
}

class Circle extends Shape {
    @Override
    void area() {
        System.out.println("Area of Circle");
    }

    @Override
    double calculateArea(int r) {
        return 3.14 * r * r;
    }
}

public class Abstract {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        shape1.area();
        System.out.println("Area: " + shape1.calculateArea(5));

    }
}
