package com.bluewave.androidtech.networking.utils;

import com.bluewave.androidtech.networking.adapter.RetrofitAdapter;
import com.bluewave.androidtech.networking.api.UserService;

public class NetworkingUtils {

    private static UserService userService;

    public static UserService getUserApiInstance() {
        if (userService == null)
            userService = RetrofitAdapter.getInstance().create(UserService.class);

        return userService;
    }

}