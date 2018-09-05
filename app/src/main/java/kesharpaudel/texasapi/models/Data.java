package kesharpaudel.texasapi.models;

import com.google.gson.annotations.SerializedName;

public class Data {


    @SerializedName("profilePicture")
    private String profilepicture;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;
    @SerializedName("createdByName")
    private String createdby;
    @SerializedName("mobileNumber")
    private String mobileNo;
    @SerializedName("createdDate")
    private String createdDate;



    public Data(String profilepicture, String firstName, String lastName, String email, String username, String createdby, String mobileNo, String createdDate) {
        this.profilepicture = profilepicture;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.createdby = createdby;
        this.mobileNo = mobileNo;
        this.createdDate = createdDate;
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
    public String getCreatedby() {
        return createdby;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
