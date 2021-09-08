package com.aariyan.mvvmwithrestapi.Interface;

import com.aariyan.mvvmwithrestapi.Model.Picsum;

import java.util.List;

public interface GenericCallback {

    void onSuccess (List<Picsum> listOfData);
    void onError (String errorMessage);
}
