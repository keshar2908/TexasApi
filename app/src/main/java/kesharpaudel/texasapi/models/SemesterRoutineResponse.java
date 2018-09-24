package kesharpaudel.texasapi.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SemesterRoutineResponse {

    @SerializedName("semester")
    @Expose
    private String semester;
    @SerializedName("routines")
    @Expose
    private List<Routine> routines = null;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<Routine> getRoutines() {
        return routines;
    }

    public void setRoutines(List<Routine> routines) {
        this.routines = routines;
    }


    @Override
    public String toString() {
        return "SemesterRoutineResponse{" +
                "semester='" + semester + '\'' +
                ", routines=" + routines +
                '}';
    }
}
