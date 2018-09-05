package kesharpaudel.texasapi.activitis;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parent {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("fullName")
    @Expose
    private String fullName;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("homeOfficeNumber")
    @Expose
    private String homeOfficeNumber;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("relation")
    @Expose
    private String relation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getHomeOfficeNumber() {
        return homeOfficeNumber;
    }

    public void setHomeOfficeNumber(String homeOfficeNumber) {
        this.homeOfficeNumber = homeOfficeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
