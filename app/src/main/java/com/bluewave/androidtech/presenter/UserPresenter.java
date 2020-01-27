package com.bluewave.androidtech.presenter;

import com.bluewave.androidtech.callback.Callback;
import com.bluewave.androidtech.model.User;
import com.bluewave.androidtech.utils.UserTask;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {
    private UserContract.View mView;

    public UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadUsers() {
        UserTask.getUsers(new Callback<List<User>>() {
            @Override
            public void returnResult(List<User> users) {
                mView.loadDataInList(users);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }

    @Override
    public void start() {
        mView.init();
    }

}