package com.thejoker.searchrepository.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thejoker.searchrepository.R;
import com.thejoker.searchrepository.mvp.model.Item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private List<Item> list = new ArrayList<>();
    private LayoutInflater inflater;

    public RepoAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public void addRepo(List<Item> repo) {
        list.addAll(repo);
        notifyDataSetChanged();
    }

    public void clearRepo() {
        list.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_list_cv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getList(), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.iv_profile)
        ImageView ivProfile;
        private Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            ButterKnife.bind(this, itemView);

        }

        public void bind(List<Item> repo, int position) {
            tvName.setText(repo.get(position).getFullName());
            Picasso.get().load(repo.get(position).getOwner().getAvatarUrl()).into(ivProfile);
        }
    }
}
