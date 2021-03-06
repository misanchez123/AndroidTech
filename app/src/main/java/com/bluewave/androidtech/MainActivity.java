package com.bluewave.androidtech;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bluewave.androidtech.adaper.CustomAdapter;
import com.bluewave.androidtech.databinding.ActivityMainBinding;
import com.bluewave.androidtech.model.User;
import com.bluewave.androidtech.presenter.UserContract;
import com.bluewave.androidtech.presenter.UserPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements UserContract.View {

    private ActivityMainBinding mBinding;
    private UserContract.Presenter mPresenter;
    private RecyclerView recyclerview;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new UserPresenter(this);
        mPresenter.start();
    }

    @Override
    public void init() {
        recyclerview = mBinding.recyclerView;
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        mPresenter.loadUsers();
    }

    @Override
    public void loadDataInList(List<User> users) {
        adapter = new CustomAdapter(users);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
