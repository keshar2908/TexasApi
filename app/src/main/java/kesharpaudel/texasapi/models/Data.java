package kesharpaudel.texasapi.models;

import com.google.gson.annotations.SerializedName;

public class Data {



    @SerializedName("profilePicture")
    private String profilepicture;




    private  String firstName;

    private String lastName;

    private String email;


    private String username;


    public Data(String profilepicture,String firstName, String lastName, String email, String username) {

        this.profilepicture=profilepicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
    }
    public String getProfilepicture() {
        return profilepicture;
    }

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
}
