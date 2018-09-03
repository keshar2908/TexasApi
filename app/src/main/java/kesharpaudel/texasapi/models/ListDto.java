package kesharpaudel.texasapi.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListDto {

    @SerializedName("total")
    Long total;
    @SerializedName("data")
    java.util.List<Data> data;
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
