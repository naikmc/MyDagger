package com.example.ga_mlsdiscovery.mydaggertest.di;

import android.app.Application;
import android.content.Context;

import com.example.ga_mlsdiscovery.mydaggertest.DemoApplication;
import com.example.ga_mlsdiscovery.mydaggertest.data.DataManager;
import com.example.ga_mlsdiscovery.mydaggertest.data.DbHelper;
import com.example.ga_mlsdiscovery.mydaggertest.data.SharedPrefsHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}