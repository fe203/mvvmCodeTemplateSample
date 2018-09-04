package com.lyne.mvvmcodetemplatesample.factory;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModelStore;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liht on 2018/9/4.
 */

public class ViewModelStoreFactory {

    class RefStore{
        ViewModelStore viewModelStore;
        List<Activity> relativeActivities = new ArrayList<>();
    }

    private static ViewModelStoreFactory factory;

    private HashMap<String, RefStore> refStoreHashMap = new HashMap<>();

    private ViewModelStoreFactory(Application application){
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks(){

            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

                for (Map.Entry<String, RefStore> entry : refStoreHashMap.entrySet()){
                    RefStore refStore = entry.getValue();
                    if (refStore != null){
                        if (refStore.relativeActivities != null){
                            refStore.relativeActivities.remove(activity);
                            if (refStore.relativeActivities.isEmpty()){
                                refStore.viewModelStore.clear();
                            }
                        }

                    }
                }

            }
        });
    }

    public static ViewModelStoreFactory getFactory(Application application){
        if (factory == null){
            factory = new ViewModelStoreFactory(application);
        }

        return factory;
    }

    public ViewModelStore getViewModelStore(Activity activity, Class<? extends AndroidViewModel> clazz){

        String canonical = clazz.getCanonicalName();

        RefStore refStore = refStoreHashMap.get(canonical);
        if (refStore == null){
            refStore = new RefStore();
            refStoreHashMap.put(canonical, refStore);
        }

        if (refStore.viewModelStore == null){
            refStore.viewModelStore = new ViewModelStore();
        }

        if (!refStore.relativeActivities.contains(activity)){
            refStore.relativeActivities.add(activity);
        }

        return refStore.viewModelStore;
    }
}
