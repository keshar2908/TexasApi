package kesharpaudel.texasapi.models;

public class User {

    private long customerId;

    private long loginId;
    private String token;

    private String firstName,lastName,email,username,profilePicture;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public User(long customerId, long loginId, String token, String firstName, String lastName, String email, String username, String profilePicture) {

        this.customerId = customerId;
        this.loginId = loginId;
        this.token = token;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.profilePicture = profilePicture;
    }

    public User(String token) {

        this.token = token;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getLoginId() {
        return loginId;
    }

    public String getToken() {
        return token;
    }

    public User(long loginId, long customerId, String token) {

        this.loginId = loginId;

        this.customerId = customerId;

        this.token = token;
    }
}
