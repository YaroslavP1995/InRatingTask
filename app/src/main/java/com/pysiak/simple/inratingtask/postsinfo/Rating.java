package com.pysiak.simple.inratingtask.postsinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rating {
    @SerializedName("level")
    @Expose
    private int level;
    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("proportion")
    @Expose
    private float proportion;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public float getProportion() {
        return proportion;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }
}
