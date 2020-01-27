package com.bluewave.androidtech.networking.api;

import com.bluewave.androidtech.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserService {

    @GET("/posts/")
    Observable<List<User>> getUsers();

}