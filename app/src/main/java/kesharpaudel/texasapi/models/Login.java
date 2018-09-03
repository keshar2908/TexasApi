package kesharpaudel.texasapi.models;

public class Login {

    private String password;
    private String username;

    public Login(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
