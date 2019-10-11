package com.pysiak.simple.inratingtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;

import com.pysiak.simple.inratingtask.usersinfo.Users;
import com.pysiak.simple.inratingtask.usersinfo.UsersInfo;
import com.pysiak.simple.inratingtask.postsinfo.PostsInfo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main class, launcher activity for application
 *
 * @author Yaroslav P.
 */
public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerLikers;
    RecyclerView recyclerReposters;
    RecyclerView recyclerComentators;
    RecyclerView recyclerMentions;

    PostsAdapter likersAdapter;
    PostsAdapter repostersAdapter;
    PostsAdapter comentatorsAdapter;
    PostsAdapter mentionsAdapter;

   private TextView textViewsCount;
   private TextView textViewLikersCount;
   private TextView textViewComentatorsCount;
   private TextView textViewMentionsCount;
   private TextView textViewRepostsCount;
   private TextView textViewBookmarksCountPost;
   private static final int USER_ID = 2028;
   List<Users> usersInfo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewsCount = findViewById(R.id.views_count);
        textViewLikersCount = findViewById(R.id.likers_count);
        textViewComentatorsCount = findViewById(R.id.comentators_count);
        textViewMentionsCount = findViewById(R.id.mentions_count);
        textViewRepostsCount = findViewById(R.id.reposts_count);
        textViewBookmarksCountPost = findViewById(R.id.bookmarks_count_post);

        recyclerLikers = (RecyclerView) findViewById(R.id.likers_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerLikers.setLayoutManager(layoutManager);
        likersAdapter = new PostsAdapter(usersInfo,this);
        recyclerLikers.setAdapter(likersAdapter);

        recyclerReposters = (RecyclerView)findViewById(R.id.reposts_recycle_view);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerReposters.setLayoutManager(linearLayoutManager1);
        repostersAdapter = new PostsAdapter(usersInfo,this);
        recyclerReposters.setAdapter(repostersAdapter);

        recyclerComentators = (RecyclerView)findViewById(R.id.comentators_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerComentators.setLayoutManager(linearLayoutManager);
        comentatorsAdapter = new PostsAdapter(usersInfo,this);
        recyclerComentators.setAdapter(comentatorsAdapter);

        recyclerMentions = (RecyclerView)findViewById(R.id.mentions_recycle_view);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerMentions.setLayoutManager(linearLayoutManager2);
        mentionsAdapter = new PostsAdapter(usersInfo,this);
        recyclerMentions.setAdapter(mentionsAdapter);

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
                //Log.i("TEST_getLikers", "response.body = " + response.body().getData().size());
                Log.i("TEST_getLikers", "message = " + response.message());
                if (response.body() != null) {
                    likersAdapter.setUsers(response.body().getData());
                    textViewLikersCount.setText(response.body().getData().size()+"");
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
                    repostersAdapter.setUsers(response.body().getData());
                    textViewRepostsCount.setText(response.body().getData().size()+"");
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
                    comentatorsAdapter.setUsers(response.body().getData());
                    textViewComentatorsCount.setText(response.body().getData().size()+"");
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
                    mentionsAdapter.setUsers(response.body().getData());
                    textViewMentionsCount.setText(response.body().getData().size()+" ");
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
                    textViewsCount.setText(response.body().getViewsCount()+"");
                    textViewBookmarksCountPost.setText(response.body().getBookmarksCount()+" ");
                }
            }
            @Override
            public void onFailure(Call<PostsInfo> call, Throwable t) {
                Log.i("TEST_getBookmarks", "message = " + t.getMessage());
            }
        });
    }
}
