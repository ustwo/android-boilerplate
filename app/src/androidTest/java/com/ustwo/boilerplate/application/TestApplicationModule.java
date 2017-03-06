package com.ustwo.boilerplate.application;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import dagger.Module;
import dagger.Provides;

@Module
public class TestApplicationModule {
    private final Application application;

    TestApplicationModule(@NonNull final Application application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application;
    }
}
