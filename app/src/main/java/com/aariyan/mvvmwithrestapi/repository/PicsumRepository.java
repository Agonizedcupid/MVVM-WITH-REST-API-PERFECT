package com.aariyan.mvvmwithrestapi.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.aariyan.mvvmwithrestapi.Interface.GenericCallback;
import com.aariyan.mvvmwithrestapi.Model.Picsum;
import com.aariyan.mvvmwithrestapi.Networking.Networking;
import com.aariyan.mvvmwithrestapi.constant.Constant;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PicsumRepository {
    private static PicsumRepository instance;
    MutableLiveData<List<Picsum>> l = new MutableLiveData<>();

    public static PicsumRepository getInstance() {
        if (instance == null) {
            instance = new PicsumRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Picsum>> getData(Context context) {
        Networking networking = new Networking(context);
        networking.gettingDataFromInternet(new GenericCallback() {
            @Override
            public void onSuccess(List<Picsum> listOfData) {
                l.setValue(listOfData);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
        return l;
    }


}
