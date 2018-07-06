package com.blogspot.pavankreddytadi.roomviewmodellivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase.FavoriteMovie;
import com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase.MyDatabaseClass;

import java.util.ArrayList;
import java.util.List;
//Created by PAVAN for Training APSSDC Mentors and Students
public class MoviesListActivity extends AppCompatActivity
{

    MyDatabaseClass myDatabaseClass;
    MoviesListViewModel viewModel;
    List<FavoriteMovie> lists;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_list);
        lists = new ArrayList<>();
        myDatabaseClass = Room.databaseBuilder(this,MyDatabaseClass.class,"myroom.db").allowMainThreadQueries().build();
        viewModel = ViewModelProviders.of(this).get(MoviesListViewModel.class);
        List<FavoriteMovie> favoriteMovies = myDatabaseClass.myDaoMethod().getAllMovies();
        viewModel.setList(favoriteMovies);
        recyclerView = findViewById(R.id.recyclerview);
        android.arch.lifecycle.Observer<List<FavoriteMovie>> observer = new android.arch.lifecycle.Observer<List<FavoriteMovie>>() {
            @Override
            public void onChanged(@Nullable List<FavoriteMovie> favoriteMovies) {
                recyclerView.setAdapter(new MyAdapter(MoviesListActivity.this, favoriteMovies));
            }
        };
        viewModel.getList().observe(this,observer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addMovie(View view)
    {
        startActivity(new Intent(this,AddMovieActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        lists = myDatabaseClass.myDaoMethod().getAllMovies();
        viewModel.getList().setValue(lists);
    }
}
