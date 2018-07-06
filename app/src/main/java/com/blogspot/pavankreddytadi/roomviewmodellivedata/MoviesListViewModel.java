package com.blogspot.pavankreddytadi.roomviewmodellivedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.blogspot.pavankreddytadi.roomviewmodellivedata.RoomDatabase.FavoriteMovie;

import java.util.List;
//Created by PAVAN for Training APSSDC Mentors and Students
public class MoviesListViewModel extends ViewModel
{
    private MutableLiveData<List<FavoriteMovie>> listMutableLiveData = new MutableLiveData<>();
    public MoviesListViewModel() {
        listMutableLiveData = new MutableLiveData<List<FavoriteMovie>>();
    }

    public MutableLiveData<List<FavoriteMovie>> getList() {
        if(listMutableLiveData == null)
        {
            listMutableLiveData = new MutableLiveData<List<FavoriteMovie>>();
        }
        return listMutableLiveData;
    }

    public void setList(List<FavoriteMovie> list)
    {
        listMutableLiveData.setValue(list);
    }
}
