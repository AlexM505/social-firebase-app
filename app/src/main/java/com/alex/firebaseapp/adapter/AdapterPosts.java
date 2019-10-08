package com.alex.firebaseapp.adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alex.firebaseapp.R;
import com.alex.firebaseapp.model.ModelPost;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class AdapterPosts extends RecyclerView.Adapter<AdapterPosts.MyHolder>{

    Context context;
    List<ModelPost> postList;

    public AdapterPosts(Context context, List<ModelPost> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_posts,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        String uid = postList.get(position).getUid();
        String uEmail = postList.get(position).getuEmail();
        String uName = postList.get(position).getuName();
        String uDp = postList.get(position).getuDp();
        String pId = postList.get(position).getpId();
        String pTitle = postList.get(position).getpTitle();
        String pDescr = postList.get(position).getpDescr();
        String pImage = postList.get(position).getpImage();
        String pTimeStamp = postList.get(position).getpTimer();

        //convertir pTimeStamp a dd/mm/yyyy
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(pTimeStamp));
        String pTime = DateFormat.format("dd/MM/yyyy hh:mm aa",calendar).toString();

        holder.uNameTv.setText(uName);
        holder.pTimeTv.setText(pTime);
        holder.pTitleTv.setText(pTitle);
        holder.pDescrTv.setText(pDescr);

        try{
            Picasso.get().load(uDp).placeholder(R.drawable.ic_default_img).into(holder.uPictureIv);
        }catch(Exception e){

        }

        if(pImage.equals("noImage")){
            holder.pImageIv.setVisibility(View.GONE);
        }else{
            try{
                Picasso.get().load(pImage).into(holder.pImageIv);
            }catch(Exception e){

            }
        }

        holder.moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Mas...", Toast.LENGTH_SHORT).show();
            }
        });

        holder.likesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Tuani...", Toast.LENGTH_SHORT).show();
            }
        });

        holder.commentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Comentario...", Toast.LENGTH_SHORT).show();
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Compartir...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        ImageView uPictureIv, pImageIv;
        TextView uNameTv, pTimeTv, pTitleTv, pDescrTv, pLikesTv;
        ImageButton moreBtn;
        Button likesBtn, commentBtn, shareBtn;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            uPictureIv = itemView.findViewById(R.id.uPictureIv);
            pImageIv = itemView.findViewById(R.id.pImageIv);
            uNameTv = itemView.findViewById(R.id.uNameTv);
            pTimeTv = itemView.findViewById(R.id.pTimeTv);
            pTitleTv = itemView.findViewById(R.id.pTitleTv);
            pDescrTv = itemView.findViewById(R.id.pDescriptionTv);
            pLikesTv = itemView.findViewById(R.id.pLikesTv);
            moreBtn = itemView.findViewById(R.id.moreBtn);
            likesBtn = itemView.findViewById(R.id.likeBtn);
            commentBtn = itemView.findViewById(R.id.commentBtn);
            shareBtn = itemView.findViewById(R.id.shareBtn);
        }
    }
}
