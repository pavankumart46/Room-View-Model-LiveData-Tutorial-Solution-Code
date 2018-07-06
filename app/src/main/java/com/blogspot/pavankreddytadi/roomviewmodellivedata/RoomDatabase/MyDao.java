package com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.graphics.Movie;

import java.util.List;

@Dao
public interface MyDao
{
    @Query("SELECT * FROM favourites")
    List<FavoriteMovie> getAllMovies();

    @Insert
    void insertData(FavoriteMovie movie);

    @Delete
    void deleteData(FavoriteMovie movie);

}
