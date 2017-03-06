package com.ustwo.boilerplate.feature.helloworld;

import android.support.annotation.NonNull;
import com.ustwo.boilerplate.R;
import com.ustwo.boilerplate.base.BaseActivity;
import com.ustwo.boilerplate.base.BasePresenter;
import javax.inject.Inject;

public class HelloWorldActivity extends BaseActivity<HelloWorldPresenter.View>
        implements HelloWorldPresenter.View {

    @Inject HelloWorldPresenter presenter;

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

    @Override
    protected void onInject() {
        DaggerHelloWorldComponent.builder().applicationComponent(getApplicationComponent()).build()
                .inject(this);
    }
}
