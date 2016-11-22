package com.ustwo.boilerplate.application;

import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {TestApplicationModule.class})
public interface TestApplicationComponent extends ApplicationComponent {
}
