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
    /*@SerializedName("lat")
    @Expose
    private Object lat;
    @SerializedName("lng")
    @Expose
    private Object lng;
    @SerializedName("locality")
    @Expose
    private Object locality;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("administrative_area_level_1")
    @Expose
    private Object administrativeAreaLevel1;
    @SerializedName("administrative_area_level_2")
    @Expose
    private Object administrativeAreaLevel2;
    @SerializedName("address_components")
    @Expose
    private Object addressComponents;*/

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

   /* public Object getLat() {
        return lat;
    }

    public void setLat(Object lat) {
        this.lat = lat;
    }

    public Object getLng() {
        return lng;
    }

    public void setLng(Object lng) {
        this.lng = lng;
    }

    public Object getLocality() {
        return locality;
    }

    public void setLocality(Object locality) {
        this.locality = locality;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Object getAdministrativeAreaLevel1() {
        return administrativeAreaLevel1;
    }

    public void setAdministrativeAreaLevel1(Object administrativeAreaLevel1) {
        this.administrativeAreaLevel1 = administrativeAreaLevel1;
    }

    public Object getAdministrativeAreaLevel2() {
        return administrativeAreaLevel2;
    }

    public void setAdministrativeAreaLevel2(Object administrativeAreaLevel2) {
        this.administrativeAreaLevel2 = administrativeAreaLevel2;
    }

    public Object getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(Object addressComponents) {
        this.addressComponents = addressComponents;
    }*/
}
