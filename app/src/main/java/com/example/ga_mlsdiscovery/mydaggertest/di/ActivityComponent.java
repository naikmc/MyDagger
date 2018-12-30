package com.example.ga_mlsdiscovery.mydaggertest.di;

import com.example.ga_mlsdiscovery.mydaggertest.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
