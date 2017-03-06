package com.ustwo.boilerplate.feature.home;

import com.ustwo.boilerplate.application.ApplicationComponent;
import com.ustwo.boilerplate.base.PerViewScope;
import dagger.Component;

@PerViewScope
@Component(dependencies = ApplicationComponent.class)
interface HomeComponent {
    void inject(HomeActivity activity);
}
