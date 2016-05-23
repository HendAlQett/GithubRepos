package adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hend.githubrepos.R;

import java.util.ArrayList;
import java.util.List;

import modules.Github;

/**
 * Created by hend on 5/23/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final List<Github> mGithubUsersList;

    public CardAdapter() {
        this.mGithubUsersList = new ArrayList<>();
    }

    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void addData(Github github) {
        mGithubUsersList.add(github);
        notifyDataSetChanged();
    }

    public void clear() {
        mGithubUsersList.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(CardAdapter.ViewHolder holder, int position) {
        Github github = mGithubUsersList.get(position);
        holder.login.setText(github.getLogin());
        holder.repos.setText("repos: " + github.getPublicRepos());
        holder.blog.setText("blog: " + github.getBlog());

    }

    @Override
    public int getItemCount() {
        return mGithubUsersList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView login, repos, blog;


        public ViewHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            repos = (TextView) itemView.findViewById(R.id.repos);
            blog = (TextView) itemView.findViewById(R.id.blog);
        }
    }

}
