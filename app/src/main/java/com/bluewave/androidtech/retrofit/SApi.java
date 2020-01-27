package com.bluewave.androidtech.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SApi {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com//";
    private static IApi sMyAPI;

    private SApi() {

    }

    public static IApi getMyAPI() {
        init();
        return sMyAPI;
    }

    private static void init() {
        if (sMyAPI == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            sMyAPI = retrofit.create(IApi.class);
            //If you break up your API into different interfaces you can initialize them all here.
        }
    }
}
