package com.ustwo.boilerplate.application;

public class Application extends android.app.Application {

  private final ApplicationComponent applicationComponent = createComponent();

  protected ApplicationComponent createComponent() {
    return DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
