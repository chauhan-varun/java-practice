public class Illegal {
    static void fun(int x) throws IllegalAccessException {

        if (x < 0) {
            throw new IllegalAccessException("Negative value is not allowed");
        } else if (x > 0 && x < 10) {
            throw new ArithmeticException("Value is too small");
        } else {
            System.out.println("Value is: " + x);
        }
    }

    public static void main(String[] args) {
        try {
            fun(5);
        } catch (IllegalAccessException e) {
            System.out.println("Caught exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
