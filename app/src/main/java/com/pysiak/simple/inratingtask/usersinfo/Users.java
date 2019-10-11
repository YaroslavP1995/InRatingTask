package com.pysiak.simple.inratingtask.usersinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Users {

    @SerializedName("nickname")
    @Expose
    private String nickname;

    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }
}
