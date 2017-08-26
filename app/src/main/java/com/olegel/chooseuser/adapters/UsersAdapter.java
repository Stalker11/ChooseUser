package com.olegel.chooseuser.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.olegel.chooseuser.R;
import com.olegel.chooseuser.models.UserModel;
import com.olegel.chooseuser.util.RecyclerViewOnItemClick;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private Unbinder unbinder;
    private List<UserModel> users;
    private View view;
    private Context cont;
    private ViewHolder viewHolder;
    private RecyclerViewOnItemClick listener;
    public static final String TAG = UsersAdapter.class.getSimpleName();

    public UsersAdapter(List<UserModel> users) {
        this.users = users;
    }

    /**
     * Unbind butterKnife in adapter
     */
    public void unbindButterKnife() {
        if (unbinder != null) unbinder.unbind();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_layout, parent, false);
        viewHolder = new ViewHolder(view);
        cont = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(users.get(position));
                }
            }
        });
        holder.userName.setText(users.get(position).getName());
        holder.userLastName.setText(users.get(position).getLastName());
        Picasso.with(cont)
                .load(users.get(position).getImageLink())
                .fit()
                .centerCrop()
                .into(holder.userAvatar);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.user_list_last_name)
        TextView userLastName;
        @BindView(R.id.user_list_avatar)
        ImageView userAvatar;

        public ViewHolder(View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }

    /**
     * Set custom onClickListener for recyclerView
     *
     * @param onClickListener listener
     */
    public void setOnItemClickListener(RecyclerViewOnItemClick onClickListener) {
        this.listener = onClickListener;
    }
}
