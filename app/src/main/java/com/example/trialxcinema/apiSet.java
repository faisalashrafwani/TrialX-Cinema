package com.example.trialxcinema;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiSet {
    @GET("movie/popular")
    Call<Response> getData(@Query("api_key") String api_key);
}
