package com.pysiak.simple.inratingtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pysiak.simple.inratingtask.usersinfo.Users;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Users> usersInfo = new ArrayList<>();
    private Context context;

    PostsAdapter(List<Users> usersInfo, Context context){
        this.usersInfo = usersInfo;
        this.context = context;
    }

    void setUsers(List<Users> usersInfo) {
        this.usersInfo = usersInfo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likers_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url = usersInfo.get(position).getAvatarImage().getUrlSmall();
        holder.userNameLikers.setText(usersInfo.get(position).getNickname());
        Glide.with(context)
                .load(url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (usersInfo == null)
            return 0;
        return usersInfo.size();
    }

   class ViewHolder extends RecyclerView.ViewHolder{
        TextView userNameLikers;
        ImageView imageView;

        ViewHolder(View v) {
            super(v);
            userNameLikers = (TextView) v.findViewById(R.id.likers_post);
            imageView = (ImageView)v.findViewById(R.id.image_view);
        }
    }
}

