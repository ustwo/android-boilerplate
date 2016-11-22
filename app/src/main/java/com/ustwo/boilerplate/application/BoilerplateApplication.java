package com.ustwo.boilerplate.application;

import android.app.Application;

public class BoilerplateApplication extends Application {

  private final ApplicationComponent applicationComponent = createComponent();

  protected ApplicationComponent createComponent() {
    return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
