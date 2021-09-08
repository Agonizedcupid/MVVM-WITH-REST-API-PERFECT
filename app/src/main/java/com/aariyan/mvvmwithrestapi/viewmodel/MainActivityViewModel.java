package com.aariyan.mvvmwithrestapi.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aariyan.mvvmwithrestapi.Model.Picsum;
import com.aariyan.mvvmwithrestapi.repository.PicsumRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Picsum>> imageList;
    private PicsumRepository repository;
    private Context context;

    public void init(Context context) {
        this.context = context;
        if (imageList != null) {
            return;
        }

        repository = PicsumRepository.getInstance();
        imageList = repository.getData(context);
    }

    public LiveData<List<Picsum>> getImageList() {
        return imageList;
    }

}
