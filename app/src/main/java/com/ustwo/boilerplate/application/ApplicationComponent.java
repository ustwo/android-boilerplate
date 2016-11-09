package com.ustwo.boilerplate.application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    ApplicationModule.class
})
public interface ApplicationComponent {
}
