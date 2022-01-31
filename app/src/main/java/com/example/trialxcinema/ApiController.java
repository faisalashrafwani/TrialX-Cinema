package com.example.trialxcinema;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {
    public static final String url_main = "http://api.themoviedb.org/3/";

    private static ApiController clientObject;
    private static Retrofit retrofit;

    ApiController() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url_main)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized ApiController getInstance() {
        if (clientObject == null) {
            clientObject = new ApiController();
        }
        return clientObject;
    }

    apiSet getApi() {
        return retrofit.create(apiSet.class); //Returns all the api present
    }
}
