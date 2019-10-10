package com.pysiak.simple.inratingtask;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pysiak.simple.inratingtask.usersinfo.Users;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM_LIKERS = 1;
    private static final int TYPE_ITEM_COMENTATORS = 2;
    private final int TYPE_ITEM_MENTIONS = 3;
    private final int TYPE_ITEM_REPOSTS = 4;
    private List<Users> usersInfo = new ArrayList<>();

    public void setUsers(List<Users> usersInfo) {
        this.usersInfo = usersInfo;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == TYPE_ITEM_LIKERS) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.likers_item, parent, false);
            return new LikersViewHolder(view);
        } else if (viewType == TYPE_ITEM_COMENTATORS) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comentators_item, parent, false);
            return new ComentatorsViewHolder(view);
        } else if (viewType == TYPE_ITEM_MENTIONS){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mentions_item, parent, false);
            return new MentionsViewHolder(view);
        } else if (viewType == TYPE_ITEM_REPOSTS){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reposts_item, parent, false);
            return new RepostersViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Users users = usersInfo.get(position);

        if (getItemViewType(position) == TYPE_ITEM_LIKERS) {
            ((LikersViewHolder) holder).setLikersView(usersInfo.get(position));
        } else if (getItemViewType(position) == TYPE_ITEM_COMENTATORS){
            ((ComentatorsViewHolder) holder).setComentatorsView(usersInfo.get(position));
        }else if (getItemViewType(position) == TYPE_ITEM_MENTIONS){
            ((MentionsViewHolder) holder).setMentionsView(usersInfo.get(position));
        }else if (getItemViewType(position) == TYPE_ITEM_REPOSTS){
            ((RepostersViewHolder) holder).setRepostersView(usersInfo.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (TextUtils.isEmpty(usersInfo.get(position).getNickname())) {
            return TYPE_ITEM_LIKERS;
        } else if (TextUtils.isEmpty(usersInfo.get(position).getNickname())){
            return TYPE_ITEM_COMENTATORS;
        }else if (TextUtils.isEmpty(usersInfo.get(position).getNickname())){
            return TYPE_ITEM_MENTIONS;
        }else return TYPE_ITEM_REPOSTS;
    }

    @Override
    public int getItemCount() {
        if (usersInfo == null)
            return 0;
        return usersInfo.size();
    }
   public class LikersViewHolder extends RecyclerView.ViewHolder{
        TextView userNameLikers;

        public LikersViewHolder(View v) {
            super(v);
            userNameLikers = (TextView) itemView.findViewById(R.id.likers_post);
        }

       private void setLikersView(Users users) {
           userNameLikers.setText(users.getNickname()+" ");
       }
    }
   public  class ComentatorsViewHolder extends RecyclerView.ViewHolder{

        TextView userNameComentators;
        public ComentatorsViewHolder(View view){
            super(view);
            userNameComentators = (TextView) itemView.findViewById(R.id.comentators_post);

        }
       private void setComentatorsView(Users users) {
           userNameComentators.setText(users.getNickname()+" ");
       }
    }

    public class MentionsViewHolder extends RecyclerView.ViewHolder{

        TextView userNameMentions;
        public MentionsViewHolder(View view){
            super(view);
            userNameMentions = (TextView) itemView.findViewById(R.id.mentions_post);

        }
        private void setMentionsView(Users users) {
            userNameMentions.setText(users.getNickname()+" ");
        }
    }

    public class RepostersViewHolder extends RecyclerView.ViewHolder{

    TextView userNameReposters;
    public RepostersViewHolder(View view){
        super(view);
        userNameReposters = (TextView) itemView.findViewById(R.id.repost_post);

    }
    private void setRepostersView(Users users) {
        userNameReposters.setText(users.getNickname()+" ");
    }
}
}

