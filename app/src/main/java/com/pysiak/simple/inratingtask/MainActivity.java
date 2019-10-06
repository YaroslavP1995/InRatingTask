package com.pysiak.simple.inratingtask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.pysiak.simple.inratingtask.usersinfo.UsersInfo;
import com.pysiak.simple.inratingtask.postsinfo.PostsInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


   private TextView textView;
   private TextView textView1;
   private TextView textView2;
   private TextView textView3;
   private TextView textView4;
   private static final int USER_ID = 2027;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textTest);
        textView1 = findViewById(R.id.textTest1);
        textView2 = findViewById(R.id.textTest2);
        textView3 = findViewById(R.id.textTest3);
        textView4 = findViewById(R.id.textTest4);

        getLikers();
        getReposters();
        getComentators();
        getMentions();
        getPostsData();

    }

    public void getLikers(){
        App.getApi().getLikers(USER_ID).enqueue(new Callback<UsersInfo>() {
            @Override
            public void onResponse(Call<UsersInfo> call, Response<UsersInfo> response) {
                Log.i("TEST_getLikers", "response.body = " + response.body());
                Log.i("TEST_getLikers", "message = " + response.message());
                if (response.body() != null) {
                    textView.setText(response.body().getData().size()+"");
                }
            }
            @Override
            public void onFailure(Call<UsersInfo> call, Throwable t) {
                Log.i("TEST_getLikers", "message = " + t.getMessage());
            }
        });
    }

    public void getReposters(){
        App.getApi().getReposters(USER_ID).enqueue(new Callback<UsersInfo>() {
            @Override
            public void onResponse(Call<UsersInfo> call, Response<UsersInfo> response) {
                Log.i("TEST_getReposters", "response.body = " + response.body().getData().size());
                Log.i("TEST_getReposters", "message = " + response.message());
                if (response.body() != null) {
                    textView1.setText(response.body().getData().size()+"");
                }
            }
            @Override
            public void onFailure(Call<UsersInfo> call, Throwable t) {
                Log.i("TEST_getReposters", "message = " + t.getMessage());
            }
        });

    }

    public void getComentators(){
        App.getApi().getComentators(USER_ID).enqueue(new Callback<UsersInfo>() {
            @Override
            public void onResponse(Call<UsersInfo> call, Response<UsersInfo> response) {
                Log.i("TEST_getComentators", "response.body = " + response.body());
                Log.i("TEST_getComentators", "message = " + response.message());
                if (response.body() != null) {
                    textView2.setText(response.body().getData().size()+"");
                }
            }
            @Override
            public void onFailure(Call<UsersInfo> call, Throwable t) {
                Log.i("TEST_getComentators", "message = " + t.getMessage());
            }
        });
    }

    public void getMentions(){
        App.getApi().getMentions(USER_ID).enqueue(new Callback<UsersInfo>() {
            @Override
            public void onResponse(Call<UsersInfo> call, Response<UsersInfo> response) {
                Log.i("TEST_getMentions", "response.body = " + response.body());
                Log.i("TEST_getMentions", "message = " + response.message());
                if (response.body() != null) {
                    textView3.setText(response.body().getData().size()+"");
                }
            }
            @Override
            public void onFailure(Call<UsersInfo> call, Throwable t) {
                Log.i("TEST_getMentions", "message = " + t.getMessage());
            }
        });
    }

    public void getPostsData(){
        App.getPostInfo().getPostsData(USER_ID).enqueue(new Callback<PostsInfo>() {
            @Override
            public void onResponse(Call<PostsInfo> call, Response<PostsInfo> response) {
                Log.i("TEST_getBookmarks", "response.body = " + response.body());
                Log.i("TEST_getBookmarks", "message = " + response.message());

                if (response.body() != null) {
                    textView4.setText(response.body().getViewsCount()+"");
                    //textView2.setText(response.body().getId()+" ");
                }
            }
            @Override
            public void onFailure(Call<PostsInfo> call, Throwable t) {
                Log.i("TEST_getBookmarks", "message = " + t.getMessage());
            }
        });
    }
}
