package models;

public class User {
    private String email;
    private String password;

    public User withEmail(String email) { //set
        this.email = email;
        return this;
    }

    public User withPassword(String password) { //set
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
