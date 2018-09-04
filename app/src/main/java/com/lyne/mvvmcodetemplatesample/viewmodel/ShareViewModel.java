package com.lyne.mvvmcodetemplatesample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.lyne.mvvmcodetemplatesample.model.Share;

/**
 * Created by liht on 2018-9-4.
 */

public class ShareViewModel extends AndroidViewModel {

    private MutableLiveData<Share> liveDataObserver = new MutableLiveData<>();

    public ShareViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<Share> getLiveDataObserver() {
        return liveDataObserver;
    }

    public void setValue(Share share) {
        liveDataObserver.setValue(share);
    }


}
