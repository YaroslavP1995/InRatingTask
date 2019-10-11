package com.pysiak.simple.inratingtask.usersinfo;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UsersInfoApi {

    @POST("/v1/users/posts/likers/all")
    Call<UsersInfo> getLikers(@Query("id")int id);

    @POST("/v1/users/posts/reposters/all")
    Call<UsersInfo> getReposters(@Query("id")int id);

    @POST("/v1/users/posts/commentators/all")
    Call<UsersInfo> getComentators(@Query("id")int id);

    @POST("/v1/users/posts/mentions/all")
    Call<UsersInfo> getMentions(@Query("id")int id);

}
