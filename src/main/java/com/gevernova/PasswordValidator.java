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
            return password != null &&
                    password.length() >= 8 &&
                    password.matches(".*[A-Z].*") &&
                    password.matches(".*\\d.*");
        }
}
