package com.pysiak.simple.inratingtask.postsinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoId {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("google_place_id")
    @Expose
    private String googlePlaceId;
    @SerializedName("location")
    @Expose
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
