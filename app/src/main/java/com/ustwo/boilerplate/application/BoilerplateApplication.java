package com.ustwo.boilerplate.application;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.ustwo.boilerplate.BuildConfig;
import timber.log.Timber;

public class BoilerplateApplication extends Application {

    private final ApplicationComponent applicationComponent = createComponent();

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLeakCanary();
        Stetho.initializeWithDefaults(this);
        setupTimber();
    }

    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    private void setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
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
