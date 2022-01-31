package com.example.trialxcinema;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    //Context mContext;
    List<ResponseModel> data;

    public MyAdapter(List<ResponseModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.thumbnail_design, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Glide.with(holder.thumb_img.getContext())
                .load("http://image.tmdb.org/t/p/w780/" + data.get(position).getBackdrop_path())
                .into(holder.thumb_img);
        holder.thumb_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Movie.class);
                intent.putExtra("title", data.get(position).getTitle());
                intent.putExtra("vote_average", data.get(position).getVote_average());
                intent.putExtra("release_date", data.get(position).getRelease_date());
                intent.putExtra("overview", data.get(position).getOverview());
                intent.putExtra("backdrop_path", data.get(position).getBackdrop_path());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        ImageView thumb_img;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            thumb_img = itemView.findViewById(R.id.thumb_img);
        }
    }
}