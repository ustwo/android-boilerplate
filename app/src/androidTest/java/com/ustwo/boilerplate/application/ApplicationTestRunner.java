package com.ustwo.boilerplate.application;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

public class ApplicationTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(final ClassLoader classLoader, final String className,
            final Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super
                .newApplication(classLoader, TestBoilerplateApplication.class.getName(), context);
    }
}
