class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String message){
        super(message);
    }
}
    public class Password{
        public static void validatePassword(String password)
            throws  InvalidPasswordException{
        if (password.length()<8||!password.matches(".\\d.")){
            throw new InvalidPasswordException("Password not strong enough!");
        }
        System.out.println("Password is strong!");
    }
    public static void main(String[] args){
        String password="Gautam";
        try{
            validatePassword(password);
        } catch(InvalidPasswordException e) {
            System.out.println("Caught Exception: "+ e.getMessage());
        }
    }
}