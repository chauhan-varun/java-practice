interface Shape {
    static void areaInfo() {
        System.out.println("this is area");
    }
}

interface Drawable {
    final String COLOR = "RED";

    default void defaultMethod() {
        privateMethod();
        System.out.println("This is a default method in Circle class");
    }

    private void privateMethod() {
        System.out.println("This is a private method in Circle class");
    }

}

class Circle implements Shape, Drawable {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public void areaInfo() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of circle is: " + area);
    }

    public static void main(String args[]) {

        Circle c = new Circle(3);
        c.areaInfo();
    }
}
