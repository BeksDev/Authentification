package combekaapprest.utils;

import java.util.regex.Pattern;

public class PasswordValidator {
      public static void validatePassword(String password) {
        if (password.length() < 8 || !Pattern.compile(".*[A-Z].*").matcher(password).matches() || !Pattern.compile(".*[^A-Za-z0-9].*").matcher(password).matches()) {
            throw new IllegalArgumentException("Password must have at least 8 characters, one uppercase letter, and one symbol.");
        }
    }
}
