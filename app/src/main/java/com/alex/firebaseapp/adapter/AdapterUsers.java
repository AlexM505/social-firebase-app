package com.alex.firebaseapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.firebaseapp.R;
import com.alex.firebaseapp.model.ModelUser;
import com.alex.firebaseapp.ui.ChatActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterUsers extends RecyclerView.Adapter<AdapterUsers.MyHolder>{

    Context context;
    List<ModelUser> userList;

    public AdapterUsers(Context context, List<ModelUser> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_users, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        final String hisUID = userList.get(position).getUid();
        String userImage = userList.get(position).getImage();
        String userName = userList.get(position).getName();
        final String userEmail = userList.get(position).getEmail();

        holder.mNameTv.setText(userName);
        holder.mEmailTv.setText(userEmail);

        try{
            Picasso.get().load(userImage)
                    .placeholder(R.drawable.ic_default_img)
                    .into(holder.mAvatarIv);
        }catch (Exception e){

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, ""+userEmail,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("hisUid", hisUID);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView mAvatarIv;
        TextView mNameTv, mEmailTv;

        public MyHolder(@NonNull View itemHolder){
            super(itemHolder);

            mAvatarIv = itemHolder.findViewById(R.id.avatarIv);
            mNameTv = itemHolder.findViewById(R.id.nameTv);
            mEmailTv = itemHolder.findViewById(R.id.emailTv);
        }
    }
}
