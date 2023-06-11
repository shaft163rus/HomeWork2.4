import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    private static final String ALLOWED_CHARS = "^[a-zA-Z0-9_]{1,20}$";


    public static void main(String[] args) {

        try{
            checkPassword("admin", "qwerty", "qwerty");
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }

    }

    public static void checkPassword(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (!login.matches(ALLOWED_CHARS)) {
            throw new WrongLoginException("Login is incorrect");
        }

        if (!password.matches(ALLOWED_CHARS)) {
            throw new WrongPasswordException("Password is incorrect");
        }

        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException("Passwords not matched");
        }

    }
}
