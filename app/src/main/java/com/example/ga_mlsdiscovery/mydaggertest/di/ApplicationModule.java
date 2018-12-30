package com.example.ga_mlsdiscovery.mydaggertest.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.ga_mlsdiscovery.mydaggertest.data.SharedPrefsHelper;
import com.example.ga_mlsdiscovery.mydaggertest.sample.DependencySample1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.ContentValues.TAG;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }

    @Provides
    SharedPrefsHelper provideSharedPrefsHelper(SharedPreferences sharedPreferences){
        return  new SharedPrefsHelper(sharedPreferences);
    }

    @Provides
    @Singleton
    DependencySample1 provideDependencySample1() {
        Log.d(TAG, "provideDependencySample1: provideDependencySample1 called");
        return new DependencySample1(3);
    }
}
