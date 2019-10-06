package com.pysiak.simple.inratingtask.postsinfo;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PostsInfoApi {

    @POST("/v1/users/posts/get")
    Call<PostsInfo> getPostsData(@Query("id")int id);
}
