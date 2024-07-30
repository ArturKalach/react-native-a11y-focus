package com.a11yfocus;

import android.view.ViewGroup;

import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;

public abstract class A11yFocusViewManagerSpec<T extends ViewGroup> extends ReactViewManager {
  public abstract void focus(ReactViewGroup view);
}
