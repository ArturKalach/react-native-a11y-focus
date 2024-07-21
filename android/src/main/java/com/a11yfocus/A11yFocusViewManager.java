package com.a11yfocus;

import android.graphics.Color;

import androidx.annotation.Nullable;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@ReactModule(name = A11yFocusViewManager.NAME)
public class A11yFocusViewManager extends A11yFocusViewManagerSpec<A11yFocusView> {

  public static final String NAME = "A11yFocusView";

  @Override
  public String getName() {
    return NAME;
  }

  @Override
  public A11yFocusView createViewInstance(ThemedReactContext context) {
    return new A11yFocusView(context);
  }

  @Override
  @ReactProp(name = "color")
  public void setColor(A11yFocusView view, @Nullable String color) {
    view.setBackgroundColor(Color.parseColor(color));
  }
}
