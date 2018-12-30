package com.example.ga_mlsdiscovery.mydaggertest.data;

import android.content.Context;
import android.content.res.Resources;

import com.example.ga_mlsdiscovery.mydaggertest.di.ApplicationContext;
import com.example.ga_mlsdiscovery.mydaggertest.sample.DependencySample1;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {

    private DependencySample1 mDependencySample1Instance1;
    private Context mContext;
    private DbHelper mDbHelper;
    @Inject
    public SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper, DependencySample1 dependencySample1Instanc) {
        mContext = context;
        mDbHelper = dbHelper;
        mDependencySample1Instance1 = dependencySample1Instanc;
       // mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }
}