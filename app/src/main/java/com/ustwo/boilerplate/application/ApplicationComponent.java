package com.ustwo.boilerplate.application;

import android.content.Context;
import com.ustwo.boilerplate.base.BaseComponent;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent extends BaseComponent {
  Context getContext();
}
