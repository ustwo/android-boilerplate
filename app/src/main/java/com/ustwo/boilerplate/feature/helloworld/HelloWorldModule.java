package com.ustwo.boilerplate.feature.helloworld;

import dagger.Module;
import dagger.Provides;

@Module
class HelloWorldModule {

  @HelloWorldScope
  @Provides
  HelloWorldPresenter provideHelloWorldPresenter() {
    return new HelloWorldPresenter();
  }
}
