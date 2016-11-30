package com.ustwo.boilerplate.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ustwo.boilerplate.application.ApplicationComponent;
import com.ustwo.boilerplate.application.BoilerplateApplication;

public abstract class BaseActivity<V extends BaseView, C extends BaseComponent>
    extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    createComponentAndInject();
    setContentView(getLayoutId());
    getPresenter().onViewAttached(getPresenterView());
  }

  @Override
  protected void onDestroy() {
    getPresenter().onViewDetached();
    super.onDestroy();
  }

  protected ApplicationComponent getApplicationComponent() {
    return ((BoilerplateApplication) getApplication()).getApplicationComponent();
  }

  @LayoutRes
  protected abstract int getLayoutId();

  @NonNull
  protected abstract BasePresenter<V> getPresenter();

  @NonNull
  protected abstract V getPresenterView();

  protected abstract C createComponentAndInject();
}
