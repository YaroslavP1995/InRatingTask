package com.pysiak.simple.inratingtask;

import android.app.Application;

import com.pysiak.simple.inratingtask.usersinfo.UsersInfoApi;
import com.pysiak.simple.inratingtask.postsinfo.PostsInfoApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Application class, for work with retrofit
 *
 * @author Yaroslav P.
 */
public class App extends Application {

    private static UsersInfoApi usersInfoApi;
    private static PostsInfoApi postsInfoApi;
    private static String BASE_URL = "https://api.inrating.top";

    @Override
    public void onCreate() {
        super.onCreate();
        usersInfoApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(UsersInfoApi.class);
        postsInfoApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(PostsInfoApi.class);
    }

    public static UsersInfoApi getApi() {
        return usersInfoApi;
    }

    public static PostsInfoApi getPostInfo(){
        return postsInfoApi;
    }


    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            Request.Builder builder = originalRequest
                    .newBuilder().addHeader("Authorization",
                    "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImRiYTYzMGE0YzIxYWZlNzRhYTVlNTgwZjBiZjliMDQ1YThmYzY4NWViMjE0ZmFmZTY4ZDAzMGQzZjdiNThhMDg3M2M1MzU3MTNjNjIxNmE5In0.eyJhdWQiOiIyIiwianRpIjoiZGJhNjMwYTRjMjFhZmU3NGFhNWU1ODBmMGJmOWIwNDVhOGZjNjg1ZWIyMTRmYWZlNjhkMDMwZDNmN2I1OGEwODczYzUzNTcxM2M2MjE2YTkiLCJpYXQiOjE1Njg2MzI3MDEsIm5iZiI6MTU2ODYzMjcwMSwiZXhwIjoxNjAwMjU1MTAxLCJzdWIiOiIzMDQ2MTAiLCJzY29wZXMiOltdfQ.BB_dmBJDg-NO72-HSqudwt3Ql4kO7uyVjx4sMTpMURpJZfRpd1-7wUjfERWumhp1JcQzFwiRsihKTLN_rVeLNzspcXUHtp6OTRBEPowrzhQq3tB8-mQxTL-8KV2QPOaDmYufoowtCaxbTp7ciKs7Ybs4t9XYfGQoyBurWJsspOU_ikvWHlZViHZQjs82aAIblC-XyQh94sJz0_3mDHQPcGhlpBXp-RMi-hghGZsFS_ZhugSKvz5bKeR0bzDTui1baUoGnCFOWwSDn_tek1rSpAIdOe5WK1J2Opvjx7kjq7ycjbDy8ZNurWhEExa8rrFRRHlzN2AwiWkwAd6BmMHI_nVhgGbqUzDg88_393nX8T8Fdrek-IU1k461MzAycsRiKTj_vRXVyNie25v-wg3aQ9PciB-zQH1JbBM6wPmavwi-5zWD5Ab5m3FGijBviPCnN2Q-H9aBN3zPLYrYHG305Rmq6DHc_QoC_GYISk_BbbU3_DrvnUml2ey07B0bprVKJPZWYE9LHW5A3k4-yV3eAR5rf-JcQjCigONs0lkcA9uu91R-n3VxmtIyOIO76SLdkiZEebV8yvIC696zrxPMzNktoDUc-SP359MZDHIvmtL2uyy3s83n3LtgwgamZC4e6_-GmU89npACLD5hK7-lVXeVRGAKZuhTHKWuKbEqLJ8")
                    .addHeader("Content-Type","application/json" )
                    .addHeader("Accept","application/json");

            Request newRequest = builder.build();
            return chain.proceed(newRequest);

        }
    }).build();

}
