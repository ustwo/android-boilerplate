package com.ustwo.boilerplate.application;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;

public class BoilerplateApplication extends Application {

  private final ApplicationComponent applicationComponent = createComponent();

  @Override
  public void onCreate() {
    super.onCreate();
    initialiseLeakCanary();
    Stetho.initializeWithDefaults(this);
  }

  protected ApplicationComponent createComponent() {
    return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this))
        .build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  private void initialiseLeakCanary() {
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    LeakCanary.install(this);
  }
}
