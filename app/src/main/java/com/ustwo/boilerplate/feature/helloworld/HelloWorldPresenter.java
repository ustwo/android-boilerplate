package com.ustwo.boilerplate.feature.helloworld;

import android.support.annotation.NonNull;
import com.ustwo.boilerplate.base.BasePresenter;
import com.ustwo.boilerplate.base.BaseView;

class HelloWorldPresenter extends BasePresenter<HelloWorldPresenter.View> {

  @Override
  public void onViewAttached(@NonNull final View view) {
    super.onViewAttached(view);
    view.showHello();
  }

  interface View extends BaseView {
    void showHello();
  }
}
