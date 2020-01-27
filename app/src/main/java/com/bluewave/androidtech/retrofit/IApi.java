package com.bluewave.androidtech.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApi {

    @GET("posts")
    Call<List> getPosts(@Path("user") String user);
}
