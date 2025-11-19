class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}
public class geeks {
    public static void validateEmail(String email) 
    throws InvalidEmailException {
        if (!email.contains("@") || !email.contains(".com")) {
            throw new InvalidEmailException("Invalid email!");
        }
        System.out.println("Valid Email: " + email);
    }
    public static void main(String[] args) {
        String email = "jonygautam29013@gmail.com";  
        try {
            validateEmail(email);
        } catch (InvalidEmailException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}