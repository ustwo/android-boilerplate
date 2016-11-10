package com.ustwo.boilerplate.feature.helloworld;

import com.ustwo.boilerplate.application.ApplicationComponent;
import com.ustwo.boilerplate.base.BaseComponent;

import dagger.Component;

@HelloWorldScope
@Component(dependencies =  ApplicationComponent.class, modules = HelloWorldModule.class)
interface HelloWorldComponent extends BaseComponent {
  void inject(HelloWorldActivity activity);
}
