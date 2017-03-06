package com.ustwo.boilerplate.application;

public class TestBoilerplateApplication extends BoilerplateApplication {

    @Override
    protected ApplicationComponent createComponent() {
        return DaggerTestApplicationComponent.builder()
                .testApplicationModule(new TestApplicationModule(this)).build();
    }
}
