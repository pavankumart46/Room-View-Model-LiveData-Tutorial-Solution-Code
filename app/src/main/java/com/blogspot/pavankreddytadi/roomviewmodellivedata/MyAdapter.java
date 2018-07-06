package com.blogspot.pavankreddytadi.roomviewmodellivedata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase.FavoriteMovie;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Viewinfo> {
    Context context;
    List<FavoriteMovie> list;

    public MyAdapter(Context context, List<FavoriteMovie> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewinfo onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new Viewinfo(LayoutInflater.from(context).inflate(R.layout.my_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewinfo holder, int position)
    {
       holder.detail_screen_movie_id.setText(String.valueOf(list.get(position).getMovieId()));
       holder.detail_movie_title.setText(list.get(position).getMovieName());
       holder.detail_movie_desc.setText(list.get(position).getOver_view());
       holder.detail_movie_vote_average.setText(String.valueOf(list.get(position).getVote_average()));
       holder.detail_movie_poster_path.setText(list.get(position).getPoster_path());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewinfo extends RecyclerView.ViewHolder
    {
        TextView detail_screen_movie_id,detail_movie_title,detail_movie_desc,detail_movie_vote_average,detail_movie_poster_path;
        public Viewinfo(View itemView)
        {
            super(itemView);

            detail_screen_movie_id = itemView.findViewById(R.id.display_movie_id);
            detail_movie_title = itemView.findViewById(R.id.display_movie_title);
            detail_movie_desc = itemView.findViewById(R.id.display_movie_overview);
            detail_movie_vote_average = itemView.findViewById(R.id.display_movie_vote_average);
            detail_movie_poster_path = itemView.findViewById(R.id.display_movie_poster_path);
        }
    }
}
