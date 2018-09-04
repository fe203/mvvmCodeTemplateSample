package com.lyne.mvvmcodetemplatesample.view;

import android.arch.lifecycle.ViewModelStore;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lyne.mvvmcodetemplatesample.R;
import com.lyne.mvvmcodetemplatesample.factory.ViewModelStoreFactory;
import com.lyne.mvvmcodetemplatesample.model.Share;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.lyne.mvvmcodetemplatesample.viewmodel.ShareViewModel;

/**
 * Created by liht on 2018-9-4.
 */

public class Shared1Activity extends AppCompatActivity implements ViewModelStoreOwner {

    private ShareViewModel shareViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shared1);
        initViewModel();
    }

    private void initViewModel() {
        shareViewModel = ViewModelProviders.of(this).get(ShareViewModel.class);

        shareViewModel.getLiveDataObserver().observe(this, new Observer<Share>() {
            @Override
            public void onChanged(@Nullable Share share) {
                //TODO
            }
        });
    }


    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return ViewModelStoreFactory.getFactory(getApplication()).getViewModelStore(this, ShareViewModel.class);
    }
}

