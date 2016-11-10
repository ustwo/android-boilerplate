package com.ustwo.boilerplate.application;

import android.content.Context;

import com.ustwo.boilerplate.base.BaseComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class
})
public interface ApplicationComponent extends BaseComponent {
  Context getContext();
}
