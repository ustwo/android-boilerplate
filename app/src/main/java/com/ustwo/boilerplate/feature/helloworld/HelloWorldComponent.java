package com.ustwo.boilerplate.feature.helloworld;

import com.ustwo.boilerplate.application.ApplicationComponent;
import com.ustwo.boilerplate.base.PerViewScope;
import dagger.Component;

@PerViewScope
@Component(dependencies = ApplicationComponent.class)
interface HelloWorldComponent {
    void inject(HelloWorldActivity activity);
}
