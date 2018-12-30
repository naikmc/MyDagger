package com.example.ga_mlsdiscovery.mydaggertest.sample;

import android.util.Log;

import javax.inject.Singleton;

@Singleton
public class DependencySample1 {

    private static final String TAG = "DependencySample1";

    private int value;

    public DependencySample1(int value) {
        this.value = value;
        Log.d(TAG, "DependencySample1: " + this.hashCode());
    }
}
