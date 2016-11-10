package com.ustwo.boilerplate.base;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T extends BaseView> {
  private CompositeDisposable disposables;
  private T view;

  /**
   * On view attached. To be called when your view is initialised.
   *
   * @param view View attached to the presenter
   */
  @CallSuper
  public void onViewAttached(@NonNull final T view) {
    if (this.view != null) {
      throw new IllegalStateException("View " + this.view + " is already attached. Cannot attach "
          + view);
    }
    this.view = view;
  }

  /**
   * On view detached. Intended as a cleanup process that should be called when the view will no
   * longer be in use.
   */
  @CallSuper
  public void onViewDetached() {
    if (view == null) {
      throw new IllegalStateException("View is already detached");
    }
    view = null;

    if (disposables != null) {
      disposables.dispose();
      disposables = null;
    }
  }

  /**
   * Dispose on view detach.
   *
   * @param disposable Disposable to be disposed of upon view detachment
   */
  @CallSuper
  protected void disposeOnViewDetach(@NonNull final Disposable disposable) {
    if (disposables == null) {
      disposables = new CompositeDisposable();
    }
    disposables.add(disposable);
  }

  public boolean isViewAttached() {
    return view != null;
  }
}
