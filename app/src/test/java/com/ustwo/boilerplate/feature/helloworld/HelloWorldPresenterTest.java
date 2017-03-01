package com.ustwo.boilerplate.feature.helloworld;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldPresenterTest {

  @Mock HelloWorldPresenter.View view;

  private HelloWorldPresenter presenter;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    presenter = new HelloWorldPresenter();
  }

  @Test
  public void onViewAttached_showHello() throws Exception {
    presenter.onViewAttached(view);
    Mockito.verify(view).showHello();
  }
}