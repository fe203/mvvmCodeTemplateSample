package ${packageName}.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import ${packageName}.R;
<#if generateModel>
import ${packageName}.model.${modelClass};
</#if>
<#if generateViewModel>
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import ${packageName}.viewmodel.${viewModelClass};
</#if>

/**
 * Created by ${user} on ${.now?date}.
 */

public class ${activityClass} extends AppCompatActivity {

<#if generateViewModel>	
    private ${viewModelClass} ${viewModelClass?uncap_first};
</#if>    

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<#if generateLayout>

        setContentView(R.layout.${layoutName});
</#if>
<#if generateViewModel>	
        initViewModel();
</#if>
    }

<#if generateViewModel>
    private void initViewModel() {
        ${viewModelClass?uncap_first} = ViewModelProviders.of(this).get(${viewModelClass}.class);

    <#if generateModel>
        ${viewModelClass?uncap_first}.getLiveDataObserver().observe(this, new Observer<${modelClass}>() {
            @Override
            public void onChanged(@Nullable ${modelClass} ${modelClass?uncap_first}) {
                //TODO
            }
        });
    <#else>
	${viewModelClass?uncap_first}.getLiveDataObserver().observe(this, new Observer<Object>() {
            @Override
            public void onChanged(@Nullable Object obj) {
                //TODO
            }
        });
    </#if>
    }

</#if>  

}

