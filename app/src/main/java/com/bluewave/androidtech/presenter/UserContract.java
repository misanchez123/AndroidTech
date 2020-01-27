package com.bluewave.androidtech.presenter;

import com.bluewave.androidtech.model.User;

import java.util.List;

public interface UserContract {

    interface View {
        void init();
        void showError(String message);
        void loadDataInList(List<User> users);
    }

    interface Presenter {
        void start();
        void loadUsers();
    }
}
