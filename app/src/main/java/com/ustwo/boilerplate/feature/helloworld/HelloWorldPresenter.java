package com.ustwo.boilerplate.feature.helloworld;

import com.ustwo.boilerplate.base.BasePresenter;
import com.ustwo.boilerplate.base.BaseView;
import com.ustwo.boilerplate.base.PerViewScope;
import javax.inject.Inject;

@PerViewScope
class HelloWorldPresenter extends BasePresenter<HelloWorldPresenter.View> {

    @Inject
    HelloWorldPresenter() {
    }

    interface View extends BaseView {
    }
}
