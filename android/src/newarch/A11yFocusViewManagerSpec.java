package com.a11yfocus;

import android.view.View;

import androidx.annotation.Nullable;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.A11yFocusViewManagerDelegate;
import com.facebook.react.viewmanagers.A11yFocusViewManagerInterface;

public abstract class A11yFocusViewManagerSpec<T extends View> extends SimpleViewManager<T> implements A11yFocusViewManagerInterface<T> {
  private final ViewManagerDelegate<T> mDelegate;

  public A11yFocusViewManagerSpec() {
    mDelegate = new A11yFocusViewManagerDelegate(this);
  }

  @Nullable
  @Override
  protected ViewManagerDelegate<T> getDelegate() {
    return mDelegate;
  }
}
