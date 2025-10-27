class InvalidAgeException extends Exception {
  public InvalidAgeException(String s) { super(s); }
}

public class ValidAge {
  public static void validate(int age) {
    throws InvalidAgeException {
      if (age < 18) {
        throw new InvalidAgeException("Invalid Age");
      }
      System.out.println("Valid Age: " + age);
    }
  }

  public static void main(String args[]) {
    try {
      validate(14);
    } catch (InvalidAgeException e) {
      System.out.println(e.getMessage());
    }
  }
}
