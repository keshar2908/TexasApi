
package kesharpaudel.texasapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("teamId")
    @Expose
    private Integer teamId;
    @SerializedName("teamName")
    @Expose
    private String teamName;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("sendBy")
    @Expose
    private String sendBy;
    @SerializedName("sendDate")
    @Expose
    private String sendDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendBy() {
        return sendBy;
    }

    public void setSendBy(String sendBy) {
        this.sendBy = sendBy;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

}
