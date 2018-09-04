package com.lyne.mvvmcodetemplatesample.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.lyne.mvvmcodetemplatesample.model.Single;

/**
 * Created by liht on 2018-9-4.
 */

public class SingleViewModel extends AndroidViewModel {

    private MutableLiveData<Single> liveDataObserver = new MutableLiveData<>();

    public SingleViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<Single> getLiveDataObserver() {
        return liveDataObserver;
    }

    public void setValue(Single single) {
        liveDataObserver.setValue(single);
    }


}
