package kesharpaudel.texasapi.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class teamDto {
    @SerializedName("size")
    @Expose
    private Integer size;
    @SerializedName("contents")
    @Expose
    private List<Content> contents = null;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
