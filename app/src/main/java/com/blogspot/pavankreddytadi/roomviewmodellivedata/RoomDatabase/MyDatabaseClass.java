package com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {FavoriteMovie.class},version = 1,exportSchema = false)
public abstract class MyDatabaseClass extends RoomDatabase
{
    public abstract MyDao myDaoMethod();
}
