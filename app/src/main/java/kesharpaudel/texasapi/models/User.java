package kesharpaudel.texasapi.models;

public class User {

    private long customerId;

    private long loginId;
    private String token;


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
