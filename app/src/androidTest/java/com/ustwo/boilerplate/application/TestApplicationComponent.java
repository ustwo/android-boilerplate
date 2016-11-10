package com.ustwo.boilerplate.application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
    TestApplicationModule.class
})
public interface TestApplicationComponent extends ApplicationComponent {
}
