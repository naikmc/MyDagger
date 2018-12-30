package com.example.ga_mlsdiscovery.mydaggertest;

import android.app.Application;
import android.content.Context;

import com.example.ga_mlsdiscovery.mydaggertest.data.DataManager;
import com.example.ga_mlsdiscovery.mydaggertest.data.SharedPrefsHelper;
import com.example.ga_mlsdiscovery.mydaggertest.di.ApplicationComponent;
import com.example.ga_mlsdiscovery.mydaggertest.di.ApplicationModule;
import com.example.ga_mlsdiscovery.mydaggertest.di.DaggerApplicationComponent;
import com.example.ga_mlsdiscovery.mydaggertest.sample.DependencySample1;

import javax.inject.Inject;

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;
    @Inject
    DependencySample1 dependencySample1Instance1;
    @Inject
    public SharedPrefsHelper mSharedPrefsHelper;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
