package ${packageName}.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

<#if generateModel>
import ${packageName}.model.${modelClass};
</#if>

/**
 * Created by ${user} on ${.now?date}.
 */

public class ${viewModelClass} extends AndroidViewModel {

<#if generateModel>
    private MutableLiveData<${modelClass}> liveDataObserver = new MutableLiveData<>();
<#else>
    private MutableLiveData<Object> liveDataObserver = new MutableLiveData<>();
</#if>

    public ${viewModelClass}(@NonNull Application application) {
        super(application);
    }

<#if generateModel>

    public MutableLiveData<${modelClass}> getLiveDataObserver() {
        return liveDataObserver;
    }

    public void setValue(${modelClass} ${modelClass?uncap_first}){
        liveDataObserver.setValue(${modelClass?uncap_first});
    }

<#else>

    public MutableLiveData<Object> getLiveDataObserver() {
        return liveDataObserver;
    }

    public void setValue(Object obj){
        liveDataObserver.setValue(obj);
    }

</#if>

}
