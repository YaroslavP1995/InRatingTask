package com.pysiak.simple.inratingtask.usersinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersInfo {

    @SerializedName("data")
    @Expose
    private List<Users> data ;

    public List<Users> getData() {
        return data;
    }

    public void setData(List<Users> data) {
        this.data = data;
    }
}
