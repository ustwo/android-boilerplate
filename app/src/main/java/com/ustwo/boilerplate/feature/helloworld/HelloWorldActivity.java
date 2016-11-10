package com.ustwo.boilerplate.feature.helloworld;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.ustwo.boilerplate.R;
import com.ustwo.boilerplate.application.BoilerplateApplication;
import com.ustwo.boilerplate.base.BaseActivity;
import com.ustwo.boilerplate.base.BasePresenter;

import javax.inject.Inject;

public class HelloWorldActivity extends BaseActivity<HelloWorldPresenter.View> implements
    HelloWorldPresenter.View {

  @Inject
  HelloWorldPresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    createComponentAndInject();
    super.onCreate(savedInstanceState);
  }

  @Override
  protected int getLayoutId() {
    return R.layout.activity_hello_world;
  }

  @NonNull
  @Override
  protected BasePresenter<HelloWorldPresenter.View> getPresenter() {
    return presenter;
  }

  @NonNull
  @Override
  protected HelloWorldPresenter.View getPresenterView() {
    return this;
  }

  private HelloWorldComponent createComponentAndInject() {
    final HelloWorldComponent component = DaggerHelloWorldComponent.builder()
        .applicationComponent(((BoilerplateApplication) getApplication()).getApplicationComponent())
        .helloWorldModule(new HelloWorldModule())
        .build();
    component.inject(this);
    return component;
  }
}
