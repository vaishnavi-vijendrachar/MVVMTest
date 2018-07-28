package com.example.vish.mvvmtest.service.repository;

import com.example.vish.mvvmtest.service.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL = "https://dl.dropboxusercontent.com/s/";
    @GET("2iodh4vg0eortkl/facts.json")
    Call<Result> getDetails();
}
