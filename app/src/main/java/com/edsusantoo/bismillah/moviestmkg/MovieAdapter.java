package com.edsusantoo.bismillah.moviestmkg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.edsusantoo.bismillah.moviestmkg.model.ResultsItem;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<ResultsItem> listMovie;

    public MovieAdapter(Context context, List<ResultsItem> listMovie) {
        this.context = context;
        this.listMovie = listMovie;
    }

    @NonNull
    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_movie, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.tvTitleMovie.setText(listMovie.get(i).getTitle());

        Glide.with(context).load("https://image.tmdb.org/t/p/w185" + listMovie.get(i).getBackdropPath())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(myViewHolder.imgMovie);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitleMovie;
        ImageView imgMovie;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitleMovie = itemView.findViewById(R.id.tv_title_movie);
            imgMovie = itemView.findViewById(R.id.img_movie);
        }
    }
}
