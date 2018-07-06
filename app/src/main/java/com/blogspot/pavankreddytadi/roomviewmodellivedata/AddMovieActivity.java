package com.blogspot.pavankreddytadi.roomviewmodellivedata;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase.FavoriteMovie;
import com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase.MyDatabaseClass;
//Created by PAVAN for Training APSSDC Mentors and Students
public class AddMovieActivity extends AppCompatActivity {

    EditText title,desc,poster_path,vote_average;
    MyDatabaseClass myDatabaseClass;
    MoviesListViewModel viewModel;
    List<FavoriteMovie> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movies);
        
        desc = findViewById(R.id.over_view);
        title = findViewById(R.id.movie_id);
        poster_path = findViewById(R.id.poster_path);
        vote_average = findViewById(R.id.vote_average);
        viewModel = ViewModelProviders.of(this).get(MoviesListViewModel.class);
        myDatabaseClass = Room.databaseBuilder(this,MyDatabaseClass.class,"myroom.db").allowMainThreadQueries().build();
        lists = new ArrayList<>();
    }

    public void addToDatabase(View view)
    {
       String movie_title = title.getText().toString();
       String overView = desc.getText().toString();
       double va = Double.parseDouble(vote_average.getText().toString());
       String pp = poster_path.getText().toString();
       if(!TextUtils.isEmpty(movie_title))
       {
           FavoriteMovie fm = new FavoriteMovie();
           fm.setMovieName(movie_title);
           fm.setOver_view(overView);
           fm.setVote_average(va);
           fm.setPoster_path(pp);
           myDatabaseClass.myDaoMethod().insertData(fm);
           Toast.makeText(this, "DATA INSERTED SUCCESSFULLy", Toast.LENGTH_SHORT).show();
           finish();
       }
       else
       {
           new AlertDialog.Builder(this)
                   .setTitle("ALERT")
                   .setMessage("YOU CANNOT LEAVE MOVIE TITLE EMPTY")
                   .setCancelable(true)
                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int which) {
                           dialog.cancel();
                       }
                   }).show();
       }

    }

}

