class MyException extends Exception {
    MyException(String m) {
        super(m);
    }
}

public class Exceptionalhandling {
    public static void main(String args[]) {
        try {
            throw new MyException("this is my exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
