import java.util.*;

public class MultipleException {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 50; // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds Exception caught: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Out of Bounds Exception caught: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("General Exception caught: " + e.getMessage());
        }
    }
}
