package com.lyne.mvvmcodetemplatesample.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lyne.mvvmcodetemplatesample.R;
import com.lyne.mvvmcodetemplatesample.model.Single;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.lyne.mvvmcodetemplatesample.viewmodel.SingleViewModel;

/**
 * Created by liht on 2018-9-4.
 */

public class SingleActivity extends AppCompatActivity {

    private SingleViewModel singleViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single);
        initViewModel();
    }

    private void initViewModel() {
        singleViewModel = ViewModelProviders.of(this).get(SingleViewModel.class);

        singleViewModel.getLiveDataObserver().observe(this, new Observer<Single>() {
            @Override
            public void onChanged(@Nullable Single single) {
                //TODO
            }
        });
    }


}

