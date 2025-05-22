package com.gevernova;

public class PasswordValidator {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

        public static boolean isValid(String password) {
            if (password == null || password.length() < 8) return false;
            boolean hasUpper = false, hasLower = false, hasDigit = false;

            for (char c : password.toCharArray()) {
                if (Character.isUpperCase(c)) hasUpper = true;
                else if (Character.isLowerCase(c)) hasLower = true;
                else if (Character.isDigit(c)) hasDigit = true;
                else if (Character.isWhitespace(c)) return false;
            }
            return hasUpper && hasLower && hasDigit;
        }
}
