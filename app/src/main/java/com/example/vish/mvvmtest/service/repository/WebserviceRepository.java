package com.example.vish.mvvmtest.service.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.vish.mvvmtest.service.model.Details;
import com.example.vish.mvvmtest.service.model.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebserviceRepository {

    ApiService api;
    List<Details> row;

    public WebserviceRepository() {

        //create retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(ApiService.class);
    }

    public void getDataList(final MutableLiveData<List<Details>> detailsList) {
        //add observer to monitor remote data
        //final MutableLiveData<List<Details>> data = new MutableLiveData<>();

        //call webservice
        Call<Result> call = api.getDetails();

        //asynchronus call
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {
                if(response.isSuccessful()) {
                    //simulateDelay();
                    Result result = response.body();
                    String title = result.title.toString();
                    row = result.rows;
                    detailsList.setValue(row);
                    //TODO - remove this
                    Log.d("vish", "title: " + title);
                    int i = 0;
                    for (i = 0; i < row.size(); i++) {
                        Log.d("vish", "title: " + row.get(i).getTitle());
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                detailsList.setValue(null);
                Log.d("vish", "onFailure: "+ t.fillInStackTrace());
            }
        });

        //return detailsList;

    }

    private void simulateDelay() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
