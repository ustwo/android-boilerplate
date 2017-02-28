package com.ustwo.boilerplate.base;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends BaseView> {
  private final CompositeDisposable disposables = new CompositeDisposable();
  private T view;

  protected BasePresenter() {
    // This class is designed for extension
  }

  /**
   * On view attached. To be called when your view is initialised.
   *
   * @param view View attached to the presenter
   */
  @CallSuper
  public void onViewAttached(@NonNull final T view) {
    if (isViewAttached()) {
      throw new IllegalStateException(
          "View " + this.view + " is already attached. Cannot attach " + view);
    }
    this.view = view;
  }

  /**
   * On view detached. Intended as a cleanup process that should be called when the view will no
   * longer be in use.
   */
  @CallSuper
  public void onViewDetached() {
    if (!isViewAttached()) {
      throw new IllegalStateException("View is already detached");
    }
    view = null;

    disposables.clear();
  }

  /**
   * Dispose on view detach.
   *
   * @param disposable Disposable to be disposed of upon view detachment
   */
  @CallSuper
  protected void disposeOnViewDetach(@NonNull final Disposable disposable) {
    disposables.add(disposable);
  }

  public boolean isViewAttached() {
    return view != null;
  }
}
