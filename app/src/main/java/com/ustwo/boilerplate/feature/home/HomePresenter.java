package com.ustwo.boilerplate.feature.home;

import com.ustwo.boilerplate.base.BasePresenter;
import com.ustwo.boilerplate.base.PerViewScope;
import javax.inject.Inject;

@PerViewScope
class HomePresenter extends BasePresenter<HomePresenter.View> {

    @Inject
    HomePresenter() {
    }

    interface View {
    }
}
