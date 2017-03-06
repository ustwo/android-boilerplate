package com.ustwo.boilerplate.feature.home;

import android.support.annotation.NonNull;
import com.ustwo.boilerplate.R;
import com.ustwo.boilerplate.base.BaseActivity;
import com.ustwo.boilerplate.base.BasePresenter;
import javax.inject.Inject;

public class HomeActivity extends BaseActivity<HomePresenter.View>
        implements HomePresenter.View {

    @Inject HomePresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @NonNull
    @Override
    protected BasePresenter<HomePresenter.View> getPresenter() {
        return presenter;
    }

    @NonNull
    @Override
    protected HomePresenter.View getPresenterView() {
        return this;
    }

    @Override
    protected void onInject() {
        DaggerHomeComponent.builder().applicationComponent(getApplicationComponent()).build()
                .inject(this);
    }
}
