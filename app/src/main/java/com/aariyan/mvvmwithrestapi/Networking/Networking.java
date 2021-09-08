package com.aariyan.mvvmwithrestapi.Networking;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.aariyan.mvvmwithrestapi.Interface.GenericCallback;
import com.aariyan.mvvmwithrestapi.Model.Picsum;
import com.aariyan.mvvmwithrestapi.constant.Constant;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Networking {

    private RequestQueue requestQueue;
    private Context context;
    private List<Picsum> dataList = new ArrayList<>();

    public Networking(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }
    //getting data from the internet:
    public void gettingDataFromInternet(GenericCallback callback) {
        requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest root = new JsonArrayRequest(Request.Method.GET, Constant.BASE_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    try {
                        dataList.clear();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject singleObject = response.getJSONObject(i);
                            String authorName = singleObject.getString("author");
                            String imageUrl = singleObject.getString("download_url");
                            dataList.add(new Picsum(authorName, imageUrl));
                        }
                        callback.onSuccess(dataList);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(context, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("TEST_RESULT",e.getMessage());
                        callback.onError(e.getMessage());
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                callback.onError(error.getMessage());
            }
        });

        requestQueue.add(root);
    }

}
